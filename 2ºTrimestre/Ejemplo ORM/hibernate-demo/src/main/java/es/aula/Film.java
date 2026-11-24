package es.aula;
/*
Crea la entidad Film con film_id como identificador y title como atributo.
 Añade a Actor una colección de películas con @ManyToMany
 y usa @JoinTable para indicar que la tabla intermedia es film_actor.
 En joinColumns indica la columna que enlaza con Actor y en inverseJoinColumns,
 la que enlaza con Film. Registra Film en Hibernate. 
 Para esta práctica basta con poder navegar desde Actor hasta Film.


 */

import jakarta.persistence.*;

@Entity 
@Table(name = "film")
public class Film {

@Id 
@Column (name ="film_id")
private Integer id;

@Column(name="title")
private String title;

protected Film(){

}

public Integer getId(){
    return id;
}
public String getTitle(){
    return title;
}

}
