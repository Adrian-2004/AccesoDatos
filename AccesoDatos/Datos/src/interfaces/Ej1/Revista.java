package interfaces.Ej1;

public class Revista extends Publicacion{
private int numero;

public Revista(String titulo, int añoPublicacion, int numero) {
    super(titulo, añoPublicacion);
    this.numero = numero;
}

public int getNumero() {
    return numero;
}

public void setNumero(int numero) {
    this.numero = numero;
}

@Override
public String toString() {
    return super.toString() +"Revista [numero=" + numero + "]";
}

}
