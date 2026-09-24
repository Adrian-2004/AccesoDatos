package repaso;

public class Calculadora {
public static int sumar(int num1, int num2){
    return num1+num2;
}
public static int sumar(int num1, int num2, int num3){
    return num1+num2+num3;
}

public static int sumar(double num1, double num2){
    return (int)(num1+num2);
}
public static void main(String[] args) {
    System.out.println("Sumar 2 ints: "+sumar(2,3));
    System.out.println("Sumar 3 ints: "+sumar(2,3,4));
    System.out.println("Sumar 2 doubles: "+sumar(2.5,3.5));
}
//b) solo se puede añadir el metodo de double sumar(int a, int b), porque aunque al devolver se casteen a enteros, la sobrecarga de metodos
// lo permite, ya que el tipo de dato de entrada es diferente al primer metodo creado.
// c) cambiar los nombres de los parámetros no arregla el problema, ya que el codigo se ciñe al tipo de dato, da igual que un parametro se
//llame pepe en un metodo y en el otro juan, que como ambos son del mismo tipo (int, double, long, short, byte, etc) el codigo no compila, por 
// Metodos duplicados.
}
