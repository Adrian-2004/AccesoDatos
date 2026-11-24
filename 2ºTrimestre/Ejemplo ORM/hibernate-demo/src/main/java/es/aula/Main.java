package es.aula;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaPU");
                EntityManager em = emf.createEntityManager()) {
            //---------COMIENZO PRUEBA CONEXION------------
            Object nombreBD = em
                    .createNativeQuery("SELECT DATABASE()")
                    .getSingleResult();
            System.out.println("Conexión correcta.");
            System.out.println("Base de datos: " + nombreBD);

            //----------FIN PRUEBA CONEXION----------------
            Pelicula pelicula = em.find(Pelicula.class, 1);
            if (pelicula == null) {
                System.out.println("No existe una pelicula con ID 1.");
            } else {
                System.out.println(pelicula.getTitulo());
                System.out.println("Tarifa: " + pelicula.getTarifa());
            }
            List<Pelicula> peliculas = em.createQuery("""
                    select p from Pelicula p
                    where p.idiomaId = :idioma and p.tarifa >= :minima
                    order by p.id
                    """, Pelicula.class)
                    .setParameter("idioma", 1)
                    .setParameter("minima", new BigDecimal("2.99"))
                    .getResultList();
            System.out.println("Resultados: " + peliculas.size());
            for (Pelicula p : peliculas) {
                System.out.println(p.getId() + " | " + p.getTitulo()
                        + " | " + p.getTarifa());
            }

            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();
                Pelicula pelicula2 = em.find(Pelicula.class, 1); //Digo que busque de la clase de la entidad pelicula, con clave primaria 1.
                if(pelicula2 != null){//verifico que no sea null, es decir, que existe
                    BigDecimal anterior = pelicula2.getTarifa(); //pillo la tarifa anterior
                    pelicula2.setTarifa(anterior.add(new BigDecimal("0.10"))); //cambio la tarifa anterior por la nueva introducida en el BigDecimal
                    em.flush(); //flush() envía el UPDATE pendiente a MySQL dentro de la transacción.
                    System.out.println("Tarifa anterior: "+anterior); //saco por consola la tarifa anterior
                    System.out.println("Tarifa actual: "+pelicula2.getTarifa()); //saco por consola la tarifa actualizada



                }
                tx.rollback(); //Deshace la actualización
            }catch (RuntimeException ex){
                if(tx.isActive()){ //comprueba si la actualización de datos está activa, deshace la actualización
                    tx.rollback();
                }
                throw ex; //lanza dicha excepcion en el tiempo de ejecución.
            }
            try(EntityManager verificacion = emf.createEntityManager()) { 
                Pelicula pelicula3 = verificacion.find(Pelicula.class, 1);
                if(pelicula != null){
                    System.out.println("Tras rollback: "+pelicula3.getTarifa());
                }
            }
        }
    }
}