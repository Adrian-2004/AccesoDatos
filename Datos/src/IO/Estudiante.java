package IO;

import java.io.Serializable;

public class Estudiante implements Serializable{
private String nombre;
private int edad;
double notaMedia;
transient String contraseña;
public Estudiante(String nombre, int edad, double notaMedia, String contraseña) {
    this.nombre = nombre;
    this.edad = edad;
    this.notaMedia = notaMedia;
    this.contraseña = contraseña;
}
@Override
public String toString() {
    return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", notaMedia=" + notaMedia + "]";
}


}
