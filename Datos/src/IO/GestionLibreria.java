package IO;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class GestionLibreria extends DefaultHandler {

    // Variables del libro actual
    private String isbn;
    private String idioma;
    private String titulo;
    private List<String> autores = new ArrayList<>();
    private String editorial;
    private int anio;
    private double precio;
    private String moneda;

    private StringBuilder textoCreado = new StringBuilder();

    // Estadísticas y contadores
    private int librosDesde2010 = 0;
    
    // Contadores por idioma
    private int countEs = 0;
    private int countEn = 0;
    private int countGl = 0;

    // Precios en euros
    private double precioTotalEuros = 0.0;
    private int librosEurosCount = 0;

    // Libro con más autores
    private int maxAutores = 0;
    private String libroConMasAutores = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("--- INICIO DE LA LECTURA DEL CATÁLOGO DE LIBRERÍA ---");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        textoCreado.setLength(0);

        if (qName.equalsIgnoreCase("libro")) {
            isbn = attributes.getValue("isbn");
            idioma = attributes.getValue("idioma");
            autores.clear(); // Limpiamos la lista de autores para cada libro nuevo (Pista del enunciado)
        } else if (qName.equalsIgnoreCase("precio")) {
            moneda = attributes.getValue("moneda");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        textoCreado.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String contenido = textoCreado.toString().trim();

        if (qName.equalsIgnoreCase("titulo")) {
            titulo = contenido;
        } else if (qName.equalsIgnoreCase("autor")) {
            autores.add(contenido);
        } else if (qName.equalsIgnoreCase("editorial")) {
            editorial = contenido;
        } else if (qName.equalsIgnoreCase("anio")) {
            anio = Integer.parseInt(contenido);
        } else if (qName.equalsIgnoreCase("precio")) {
            precio = Double.parseDouble(contenido);
        } else if (qName.equalsIgnoreCase("libro")) {
            
            // 1. Mostrar formato de cada libro: Título (año) - Autor1, Autor2 - Editorial - Precio MONEDA - [ISBN] - Idioma
            String listaAutores = String.join(", ", autores);
            System.out.println(titulo + " (" + anio + ") - " + listaAutores + " - " + editorial + " - " + precio + " " + moneda + " - [" + isbn + "] - " + idioma);

            // 2. Filtrar y contar los publicados a partir de 2010
            if (anio >= 2010) {
                librosDesde2010++;
            }

            // 3. Contar por idioma
            if (idioma.equalsIgnoreCase("es")) countEs++;
            else if (idioma.equalsIgnoreCase("en")) countEn++;
            else if (idioma.equalsIgnoreCase("gl")) countGl++;

            // 4. Calcular precio total y medio solo en euros (moneda="EUR")
            if (moneda != null && moneda.equalsIgnoreCase("EUR")) {
                precioTotalEuros += precio;
                librosEurosCount++;
            }

            // 5. Libro con más autores
            if (autores.size() > maxAutores) {
                maxAutores = autores.size();
                libroConMasAutores = titulo + " (" + maxAutores + " autores)";
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\n================ ESTADÍSTICAS DE LA LIBRERÍA ================");
        
        // Apartado 2: Libros a partir de 2010
        System.out.println("- Libros publicados a partir de 2010: " + librosDesde2010);

        // Apartado 3: Conteo por idioma
        System.out.println("- Libros por idioma:");
        System.out.println("  * Español (es): " + countEs);
        System.out.println("  * Inglés (en): " + countEn);
        System.out.println("  * Gallego (gl): " + countGl);

        // Apartado 4: Precio total y medio en euros
        if (librosEurosCount > 0) {
            double mediaEuros = precioTotalEuros / librosEurosCount;
            System.out.printf("- Precio total en Euros: %.2f EUR%n", precioTotalEuros);
            System.out.printf("- Precio medio en Euros: %.2f EUR%n", mediaEuros);
        } else {
            System.out.println("- No hay libros en Euros para calcular medias.");
        }

        // Apartado 5: Libro con más autores
        System.out.println("- Libro con más autores: " + libroConMasAutores);
        System.out.println("============================================================");
    }

  
    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("[WARNING] Línea " + e.getLineNumber() + ", Columna " + e.getColumnNumber() + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("[ERROR] Línea " + e.getLineNumber() + ", Columna " + e.getColumnNumber() + ": " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("[FATAL ERROR] Línea " + e.getLineNumber() + ", Columna " + e.getColumnNumber() + ": " + e.getMessage());
    }
}
