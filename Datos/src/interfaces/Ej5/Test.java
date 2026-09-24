package interfaces.Ej5;

public class Test {
public static void main(String[] args) {
        
        MetodoPago tarjeta = new PagoTarjeta("1234-5678-9012-3456");
        MetodoPago paypal = new PagoPayPal("adrian@email.com");
        MetodoPago efectivo = new PagoEfectivo();

        System.out.println(tarjeta.obtenerDescripcion());
        tarjeta.realizarPago(45.50);

        System.out.println(paypal.obtenerDescripcion());
        paypal.realizarPago(120.00);

        System.out.println(efectivo.obtenerDescripcion());
        efectivo.realizarPago(15.20);
    }
}
