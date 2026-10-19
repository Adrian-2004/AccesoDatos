package IO;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class GestionAlumnos extends DefaultHandler{
public GestionAlumnos(){
    super();
}

private String id;
private String nombre;
private String apellidos;
private String ciclo;
private double nota;
private int totalAlumnos = 0;
private double sumaNotas = 0.0;
private int aprobados = 0;
private int suspensos = 0;
private double notaMaxima = -1.0;
private String alumnoNotaMaxima = "";
private double notaMinima = 11.0;
private String alumnoNotaMinima = "";

private StringBuilder textoCreado = new StringBuilder();
@Override 
public void startDocument()throws SAXException{
    System.out.println("---INICIO DE LA LECTURA DEL DOCUMENTO XML---");
}
@Override 
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    textoCreado.setLength(0);
    
    if (qName.equalsIgnoreCase("alumno")) {
        id = attributes.getValue("id");
        System.out.println("--- INICIO DE LA LECTURA DEL ELEMENTO ALUMNO [id=" + id + "] ---");
    } else {
        System.out.println("Comienzo etiqueta xml: " + qName);
    }
}
public void characters(char[] ch, int start,int length)throws SAXException{
    textoCreado.append(ch,start,length);
}

public void endElement(String uri, String localName, String qName)throws SAXException{
    String contenido = textoCreado.toString().trim();

    if(qName.equalsIgnoreCase("nombre")){
        nombre = contenido;
        System.out.println("Final de lectura de etiqueta xml -> nombre: " + nombre);
    }else if(qName.equalsIgnoreCase("apellidos")){
        apellidos = contenido;
        System.out.println("Final de lectura de etiqueta xml -> apellidos: " + apellidos);
    }
    else if(qName.equalsIgnoreCase("ciclo")){
        ciclo = contenido;
        System.out.println("Final de lectura de etiqueta xml -> ciclo: " + ciclo);
    }
    else if(qName.equalsIgnoreCase("nota")){
        nota = Double.parseDouble(contenido);
        System.out.println("Final de lectura de etiqueta xml -> nota: " + nota);
    }
    else if(qName.equalsIgnoreCase("alumno")){
        String nombreCompleto = apellidos + ','+nombre;
        System.out.println("[" + id + "] " + apellidos + ", " + nombre + " (" + ciclo + ") - Nota: " + nota);
        System.out.println("Final de lectura de etiqueta xml -> alumno");
        System.out.println("Final de lectura de elemento XML");
        totalAlumnos++;
        sumaNotas+=nota;
        if(nota>=5){
            aprobados++;
        }else{
            suspensos++;
        }

        if(nota>notaMaxima){
            notaMaxima = nota;
            alumnoNotaMaxima = nombreCompleto +"("+nota+")";
        }
        if(nota<notaMinima){
            notaMinima = nota;
            alumnoNotaMinima = nombreCompleto +"("+nota+")";
        }

    }
        
}

@Override 
public void endDocument() throws SAXException{
    System.out.println("Fin de la lectura del XML");

    System.out.println("- Estadisticas del alumno -");
    System.out.println("Se ha leido un total de "+totalAlumnos+" alumnos");
    

    //para hacer una nota media se necesitan por lo menos 2 alumnos
    if(totalAlumnos>=2){
        double media = sumaNotas/totalAlumnos;
        System.out.println("Nota media: "+media);
        System.out.println("Nota mas alta: "+alumnoNotaMaxima);
        System.out.println("Nota mas baja: "+alumnoNotaMinima);
        System.out.println("Han aprobado "+aprobados+" alumnos");
        System.out.println("Han suspendido "+suspensos+" alumnos");


    }else{
        System.out.println("para poder comparar notas se necesitan al menos dos alumnos");
    }
    System.out.println("Final del programa");
}

}

