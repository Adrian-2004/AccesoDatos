package interfaces.Ej1;

public class Publicacion {
private String titulo;
private int añoPublicacion;
public Publicacion(String titulo, int añoPublicacion) {
    this.titulo = titulo;
    this.añoPublicacion = añoPublicacion;
}
public String getTitulo() {
    return titulo;
}
public int getAñoPublicacion() {
    return añoPublicacion;
}
@Override
public String toString() {
    return "Publicacion [titulo=" + titulo + ", añoPublicacion=" + añoPublicacion + "]";
}

}
