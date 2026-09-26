package interfaces.Ej7;

public class Main {
public static void main(String[] args) {
        // 1. Usando variable de tipo Imprimible
        Imprimible imp1 = new Factura(101, 250.0);
        Imprimible imp2 = new Informe("Ventas Q3", "Las ventas han subido un 15%.");

        imp1.imprimir(); 
        imp2.imprimir(); 

        System.out.println("----------------------------------------");

        Resumible res1 = new Factura(102, 500.0);
        
        System.out.println(res1.obtenerResumen()); // FUNCIONA

       
    }
}
