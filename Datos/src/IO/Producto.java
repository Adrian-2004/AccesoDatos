package IO;

public class Producto {
private int id;
private String nombre;
private double precio;
private int existencias;
public Producto(int id, String nombre, double precio, int existencias) {
    this.id = id;
    this.nombre = formatearNombre(nombre);
    this.precio = precio;
    this.existencias = existencias;
}

private String formatearNombre(String nombreOriginal){
    if (nombreOriginal.length()>12){
        return nombreOriginal.substring(0,11)+".";
    }else {
        StringBuilder sb = new StringBuilder(nombreOriginal);
        while(sb.length()<12){
            sb.append(" ");
        }
        return sb.toString();
    }
}

public int getId() {
    return id;
}
public String getNombre() {
    return nombre;
}
public double getPrecio() {
    return precio;
}
public int getExistencias() {
    return existencias;
}
public void setPrecio(double precio) {
    this.precio = precio;
}
public void setExistencias(int existencias) {
    this.existencias = existencias;
}

@Override
public String toString() {
    return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencias=" + existencias + "]";
}



}
