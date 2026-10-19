package IO;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainGestionAlumno {
public static void main(String[] args) {
        try {
            // Creamos la factoría y el parser SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            // Instanciamos nuestro handler que procesará el XML
            GestionAlumnos handler = new GestionAlumnos();

            // Indicamos el fichero xml (asegúrate de que está en la ruta correcta del proyecto)
            File archivo = new File("alumnos.xml");

            // Ejecutamos el parseo
            parser.parse(archivo, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
