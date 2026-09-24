package interfaces.Ej8;

public class Main {
public static void main(String[] args) {
        Empleado fijo = new EmpleadoFijo("Laura", 1500.0);
        Empleado comercial = new Comercial("Carlos", 1000.0, 5000.0); // 1000 base + 10% de 5000 = 1500€

        fijo.mostrarDatos();
        comercial.mostrarDatos();
    }
}
