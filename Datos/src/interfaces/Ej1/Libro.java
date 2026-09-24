package interfaces.Ej1;

public class Libro extends Publicacion {
private boolean prestado;
public Libro(String titulo, int añoPublicacion, boolean prestado) {
    super(titulo, añoPublicacion);
    this.prestado = prestado;

}
public boolean isPrestado() {
    return prestado;

}

public void setPrestado(boolean prestado){
    this.prestado = prestado;
}
@Override
public String toString() {
    return super.toString()+"Libro [prestado=" + prestado + "]";
}



}