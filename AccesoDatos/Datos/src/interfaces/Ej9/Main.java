package interfaces.Ej9;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
        // Colección de objetos que cumplen con la interfaz Gestionable
        List<Gestionable> listaGestionables = new ArrayList<>();

        listaGestionables.add(new Producto("PROD-001"));
        listaGestionables.add(new Cliente("CLI-99"));
        listaGestionables.add(new Producto("PROD-002"));

        System.out.println("=== DESACTIVANDO TODOS LOS ELEMENTOS ===");
        for (Gestionable elemento : listaGestionables) {
            System.out.print("ID: " + elemento.getIdentificador() + " -> ");
            elemento.desactivar();
        }

        System.out.println("\n=== ACTIVANDO TODOS LOS ELEMENTOS ===");
        for (Gestionable elemento : listaGestionables) {
            System.out.print("ID: " + elemento.getIdentificador() + " -> ");
            elemento.activar();
        }
    }
}
