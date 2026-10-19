package IO;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MainLibreria {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            System.out.println("=== 1. PROCESANDO LIBRERÍA VÁLIDA ===");
            GestionLibreria handler = new GestionLibreria();
            File archivoValido = new File("libreria.xml");
            parser.parse(archivoValido, handler);

            System.out.println("\n\n=== 2. PROBANDO FICHERO ERRÓNEO (Control de Errores) ===");
            GestionLibreria handlerErroneo = new GestionLibreria();
            File archivoErroneo = new File("libreria_erroneo.xml");
            
            // Esto disparará el ErrorHandler debido a que falta la etiqueta de cierre </libreria>
            parser.parse(archivoErroneo, handlerErroneo);

        } catch (Exception e) {
            System.out.println("\n--> El parser ha detectado una excepción al procesar el archivo mal formado.");
        }
    }
}