package IO;
import java.io.Serializable;

public class Alumno implements Serializable{
private String nombre;
private String apellidos;
private String ciclo;
private String id;
private double nota;

public Alumno (String id, String nombre, String apellidos, String ciclo, double nota){
    this.id =id;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.ciclo = ciclo;
    this.nota = nota;
}

@Override
public String toString() {
    return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo + ", id=" + id + ", nota="
            + nota + "]";
}

}


