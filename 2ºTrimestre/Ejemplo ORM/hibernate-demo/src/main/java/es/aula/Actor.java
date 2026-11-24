package es.aula;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
/*
Tabla Actor
CREATE TABLE `actor` (
  `actor_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`actor_id`),
  KEY `idx_actor_last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci

*/

@Entity
@Table(name = "actor")

public class Actor {
    
@Id
@Column(name = "actor_id")
private Integer id;

@Column (name="first_name")
private String first_name;

@Column (name="last_name")
private String last_name;
 @Column (name="last_update")
 private Instant last_update;

@ManyToMany
@JoinTable(
    name = "film_actor",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "film_id")
)
private List<Film> films = new ArrayList<>();

protected Actor(){

}
public Integer getId(){
    return id;
}

public String getFirstName(){
    return first_name;
}
public String getLastName(){
    return last_name;

}
public List<Film> getFilms(){
    return films;
}


public Instant getLastUpdate(){
    return last_update;
}

}
