package interfaces.Ej8;

public class Comercial extends Empleado implements Bonificable{
private double ventas;
    private static final double PORCENTAJE_BONO = 0.10; // 10% de comisión por ventas

    public Comercial(String nombre, double salarioBase, double ventas) {
        super(nombre, salarioBase);
        this.ventas = ventas;
    }

    // Método de la interfaz Bonificable
    @Override
    public double calcularBonificacion() {
        return ventas * PORCENTAJE_BONO;
    }

    // Método abstracto heredado de Empleado
    @Override
    public double calcularSalario() {
        // Salario base + la bonificación por sus ventas
        return salarioBase + calcularBonificacion();
    }
}
