package interfaces.Ej6;

public class PagoPayPal implements MetodosPago{
private boolean cuentaVerificada;

    public PagoPayPal(boolean cuentaVerificada) {
        this.cuentaVerificada = cuentaVerificada;
    }

  
    public boolean realizarPago(double importe) {
        if (cuentaVerificada) {
            System.out.println("Pago de " + importe + "€ realizado mediante PayPal.");
            return true;
        } else {
            System.out.println("Pago de " + importe + "€ cancelado. La cuenta de PayPal no está verificada.");
            return false;
        }
    }

  
    public String obtenerDescripcion() {
        return "Pago con PayPal";
    }
}
