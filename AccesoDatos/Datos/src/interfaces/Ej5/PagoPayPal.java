package interfaces.Ej5;

public class PagoPayPal implements MetodoPago{
private String email;

public PagoPayPal(String email){
    this.email = email;
}

public String getEmail() {
    return email;
}

public void realizarPago(double importe) {
        System.out.println("Pagando " + importe + "€ a través de la cuenta de PayPal: " + email);
    }

    public String obtenerDescripcion(){
        return "Pago electrónico por PayPal";
    }
}
