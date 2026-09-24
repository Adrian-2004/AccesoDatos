package interfaces.Ej6;


public class PagoTarjeta implements MetodosPago{
private double limiteDisponible;

    public PagoTarjeta(double limiteDisponible) {
        this.limiteDisponible = limiteDisponible;
    }

    
    public boolean realizarPago(double importe) {
        if (importe <= limiteDisponible) {
            limiteDisponible -= importe;
            System.out.println("Pago de " + importe + "€ realizado con Tarjeta. Saldo restante: " + limiteDisponible + "€");
            return true;
        } else {
            System.out.println("Pago de " + importe + "€ denegado con Tarjeta. Límite insuficiente (" + limiteDisponible + "€)");
            return false;
        }
    }


    public String obtenerDescripcion() {
        return "Pago con Tarjeta de Crédito";
    }
}
