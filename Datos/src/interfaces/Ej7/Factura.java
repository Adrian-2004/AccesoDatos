package interfaces.Ej7;

public class Factura implements Imprimible, Resumible{
private int numeroFactura;

private double total;
public Factura(int numeroFactura,  double total) {
    this.numeroFactura = numeroFactura;
    
    this.total = total;
}
public void imprimir() {
        System.out.println("FACTURA COMPLETA Nº " + numeroFactura + " | Total a pagar: " + total + "€ (IVA incluido)");
    }

    public String obtenerResumen() {
        return "Factura #" + numeroFactura + " (" + total + "€)";
    }
}
