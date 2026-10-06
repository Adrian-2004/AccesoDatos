package IO;
import java.io.*;
public class Ej2 {
private static final String RUTA_FICHERO = "estudiante.ser";
    private static void guardarEstudiante(Estudiante estudiante){
        File fichero = new File(RUTA_FICHERO);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))){
            oos.writeObject(estudiante);

    }catch (IOException e){
        e.printStackTrace();
    }
}
private static Estudiante cargarEstudiante(){
    File fichero = new File(RUTA_FICHERO);
    if(!fichero.exists()){
        System.out.println("El fichero no existe");
        return null;
    }
try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))){
    return (Estudiante) ois.readObject();
}catch (IOException | ClassNotFoundException e){
    e.printStackTrace();
}
return null;
}
public static void main(String[] args) {
    Estudiante estudiante1 = new Estudiante("Adrian", 22, 6.7, "Ad1234");
guardarEstudiante(estudiante1);
System.out.println(cargarEstudiante());


}

}