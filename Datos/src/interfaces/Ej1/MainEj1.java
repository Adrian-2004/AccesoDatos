package interfaces.Ej1;

public class MainEj1 implements MetodosLibros{
public static void main(String[] args) {
    Publicacion publicaciones[] = new Publicacion[]{
        new Libro("El Quijote", 1605, false),
        new Libro("Cien años de soledad", 1967, false),
        new Revista("National Geographic", 1995, 100),
        new Revista("Muy Interesante", 1985, 45)
    };

    // Prestar uno de los libros
        ((Libro) publicaciones[0]).setPrestado(true);

        // Mostrar por pantalla los datos almacenados
        System.out.println("--- LISTA DE PUBLICACIONES ---");
        for (Publicacion p : publicaciones) {
            System.out.println(p);
        }

        // Mostrar por pantalla los resultados de los métodos estáticos
        System.out.println("\nPublicaciones prestadas: " + MetodosLibros.cuentaPrestados(publicaciones));
        System.out.println("Publicaciones anteriores a 1990: " + MetodosLibros.publicacionesAnterioresA(publicaciones, 1990));
}
}
