package es.aula;

import jakarta.persistence.*;
import java.util.List;
/*

------------------------

Tabla peliculas
	
CREATE TABLE `film` (
  `film_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `release_year` year(4) DEFAULT NULL,
  `language_id` tinyint(3) unsigned NOT NULL,
  `original_language_id` tinyint(3) unsigned DEFAULT NULL,
  `rental_duration` tinyint(3) unsigned NOT NULL DEFAULT 3,
  `rental_rate` decimal(4,2) NOT NULL DEFAULT 4.99,
  `length` smallint(5) unsigned DEFAULT NULL,
  `replacement_cost` decimal(5,2) NOT NULL DEFAULT 19.99,
  `rating` enum('G','PG','PG-13','R','NC-17') DEFAULT 'G',
  `special_features` set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`film_id`),
  KEY `idx_title` (`title`),
  KEY `idx_fk_language_id` (`language_id`),
  KEY `idx_fk_original_language_id` (`original_language_id`),
  CONSTRAINT `fk_film_language` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_language_original` FOREIGN KEY (`original_language_id`) REFERENCES `language` (`language_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci

 ------------

 CREATE TABLE `film_actor` (
  `actor_id` smallint(5) unsigned NOT NULL,
  `film_id` smallint(5) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`actor_id`,`film_id`),
  KEY `idx_fk_film_id` (`film_id`),
  CONSTRAINT `fk_film_actor_actor` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`actor_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_actor_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


Q). ¿Qué columnas forman juntas la clave primaria de film_actor? Explica por qué un mismo actor_id puede aparecer varias veces en esa tabla.
Las columnas que conforman la clave primaria en la tabla de film_actor son "actor_id" y "film_id"
se debe a que como una pelicula tiene muchos actores, y un actor puede participar en muchas peliculas
por lo tanto se produce una relacion de muchos a muchos (N:M) lo que necesita una tabla intermedia. que recoja y relacione
a cada actor con una pelicula diferente cada vez que salga.

*/

public class ActividadActores {
public static void main(String[] args) {
    
try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaPU");
        EntityManager em = emf.createEntityManager()){
      
    Actor actor  = em.find(Actor.class, 1);
    if (actor == null){
      System.out.println("No existe el actor con ID 1");
    }else{
      System.out.println("Nombre: "+actor.getFirstName()+", apellido: "+actor.getLastName()); //comrpuebo que existe el actor
      
    }
    List<Actor>actores = em.createQuery(""" 
      select a from Actor a
      order by a.id
      """,Actor.class)
      //Estas lineas de aqui, actuan como
      //un preparedStatement, si se necesita poner algun parametro
      //se usa ".setParameter(nombre, valor)"
      //y en el ps se pone en vez de las ?, se pone un :{nombre}
      .getResultList();
      
      for(Actor a :actores){
        System.out.println(a.getId()+" | "+a.getFirstName()+" | "+a.getLastName());
      }
      System.out.println("Resultados: "+actores.size());
      
      em.find(Actor.class, 1);
      if(actor == null){
        System.out.println("No existe el actor con ID 1");
      }else{
        System.out.println("Nombre: "+actor.getFirstName()+", apellido: "+actor.getLastName()); //comrpuebo que existe el actor
      }

      
    }

}
}
