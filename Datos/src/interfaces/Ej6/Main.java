package interfaces.Ej6;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
        
        List<MetodosPago> metodos = new ArrayList<>();

        metodos.add(new PagoTarjeta(100.0));     // Límite de 100€
        metodos.add(new PagoPayPal(false));       // Cuenta NO verificada
        metodos.add(new PagoEfectivo());          // Máximo 1000€ en efectivo
        metodos.add(new PagoTarjeta(500.0));     // Límite de 500€

        double importeAComprar = 150.0;

        System.out.println(" Intentando pagar un importe de  " + importeAComprar + "€ ");

        for (MetodosPago metodo : metodos) {
            System.out.println("Método: " + metodo.obtenerDescripcion());
            metodo.realizarPago(importeAComprar);
            System.out.println("--------------------------------------------------");
        }
    }
}
