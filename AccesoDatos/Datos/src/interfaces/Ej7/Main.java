package interfaces.Ej7;

public class Main {
public static void main(String[] args) {
        // 1. Usando variable de tipo Imprimible
        Imprimible imp1 = new Factura(101, 250.0);
        Imprimible imp2 = new Informe("Ventas Q3", "Las ventas han subido un 15%.");

        imp1.imprimir(); 
        imp2.imprimir(); 
        
        // imp1.obtenerResumen(); 
        // ¡ERROR DE COMPILACIÓN! Aunque 'imp1' es una Factura, la variable es de tipo 'Imprimible',
        // por lo que Java SOLO te deja usar los métodos de Imprimible.

        System.out.println("----------------------------------------");

        // 2. Usando variable de tipo Resumible
        Resumible res1 = new Factura(102, 500.0);
        
        System.out.println(res1.obtenerResumen()); // FUNCIONA

        // res1.imprimirDetalle(); 
        // ¡ERROR DE COMPILACIÓN! La variable es de tipo 'Resumible', no conoce 'imprimirDetalle()'.

        // Resumible res2 = new Informe("Test", "Texto"); 
        // ¡ERROR DE COMPILACIÓN! Un Informe NO implementa Resumible, Java no te deja asignarlo.
    }
}
