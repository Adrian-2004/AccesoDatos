package interfaces.Ej6;

public class PagoEfectivo implements MetodosPago{
private static final double MAXIMO_EFECTIVO = 1000.0;

    
    public boolean realizarPago(double importe) {
        if (importe <= MAXIMO_EFECTIVO) {
            System.out.println(" Pago de " + importe + "€ realizado en efectivo.");
            return true;
        } else {
            System.out.println("No se permiten pagos en efectivo superiores a " + MAXIMO_EFECTIVO + "€.");
            return false;
        }
    }

    
    public String obtenerDescripcion() {
        return "Pago en Efectivo";
    }
}
