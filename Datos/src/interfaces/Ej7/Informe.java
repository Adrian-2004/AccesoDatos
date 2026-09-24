package interfaces.Ej7;

public class Informe implements Imprimible {
    private String titulo;
    private String contenido;

    public Informe(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    
    public void imprimir() {
        System.out.println("INFORME: " + titulo + "\nContenido: " + contenido);
    }
}
