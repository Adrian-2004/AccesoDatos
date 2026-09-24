package interfaces.Ej5;

public class PagoTarjeta implements MetodoPago{

    private String numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
public void realizarPago(double importe){
    System.out.println("Pagando"+importe+"€ con Tarjeta de credito(" + numeroTarjeta + ").");
}
    public  String obtenerDescripcion(){
        return "Pago con tarjeta de credito/debito";
    }

}
