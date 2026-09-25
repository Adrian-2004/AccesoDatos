package interfaces.Ej9;

public class Cliente implements Gestionable, Identificable{
private String nombre;
    private boolean activo;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.activo = true;
    }

    @Override
    public String getIdentificador() {
        return "CLI-" + nombre;
    }

    @Override
    public void activar() {
        this.activo = true;
        System.out.println("Cliente " + nombre + " activado.");
    }

    @Override
    public void desactivar() {
        this.activo = false;
        System.out.println("Cliente " + nombre + " desactivado.");
    }

    public boolean isActivo() {
        return activo;
    }
}
