package interfaces.Ej5;

public class PagoEfectivo implements MetodoPago{


    public void realizarPago(double importe) {
        System.out.println("Pagando " + importe + "€ en efectivo en caja.");
    }

    public String obtenerDescripcion() {
        return "Pago físico en efectivo";
    }
}
