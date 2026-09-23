package interfaces.Ej1;

public interface MetodosLibros {
public static int cuentaPrestados(Publicacion[] publicaciones) {
    int prestados = 0;
    for (Publicacion p : publicaciones) {
        if (p instanceof Libro && ((Libro) p).isPrestado()) {
            prestados++;
        }
    }
    return prestados;
}

public static int publicacionesAnterioresA(Publicacion[] publicaciones, int año) {
    int anteriores = 0;
    for (Publicacion p : publicaciones) {
        // getAñoPublicacion() existe en Publicacion, así que sirve para Libros y Revistas
        if (p.getAñoPublicacion() < año) {
            anteriores++;
        }
    }
    return anteriores;
}
}
