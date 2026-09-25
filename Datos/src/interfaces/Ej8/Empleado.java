package interfaces.Ej8;




public abstract class Empleado {
    protected String nombre;
    protected double salarioBase; // 'protected' para que Comercial pueda acceder a salarioBase

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public void mostrarDatos() {
        System.out.println("Empleado: " + nombre + " | Salario Total: " + calcularSalario());
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

