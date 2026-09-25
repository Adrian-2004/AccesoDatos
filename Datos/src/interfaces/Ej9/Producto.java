package interfaces.Ej9;

public class Producto implements Gestionable, Identificable{
private String nombre;
    private boolean activo;

    public Producto(String nombre) {
        this.nombre = nombre;
        this.activo = true;
    }

    @Override
    public String getIdentificador() {
        return "PROD-" + nombre;
    }

    @Override
    public void activar() {
        this.activo = true;
        System.out.println("Producto " + nombre + " activado.");
    }

    @Override
    public void desactivar() {
        this.activo = false;
        System.out.println("Producto " + nombre + " desactivado.");
    }

    public boolean isActivo() {
        return activo;
    }

}
