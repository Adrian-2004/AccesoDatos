package IO;
import java.io.*;
import java.util.Scanner;
/*
Escribe un programa que cree un archivo que contiene parejas de números enteros

separados por blanco en cada línea. La introducción de datos finaliza si escribimos INTRO al

comienzo de una línea.
*/ 
public class Ej1 {
    public static void main(String[] args) {
        System.out.println("Escribe parejas de numeros enteros separados por espacio (o INTRO para finalizar):");
        File archivo = new File("enteros.txt");
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            while (true){
                String linea = sc.nextLine();
                if (linea.isEmpty()){
                    break;
                }
            bw.write(linea);
            bw.newLine();
            }
            bw.close();

        }catch (IOException e){
        System.out.println("Error al crear el archivo"+e.getMessage());
        }
        sc.close();
        System.out.println("Archivo creado correctamente");
    }
}
