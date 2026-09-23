package Excepciones;

public class Excepcion3 {
static void divide(){
int num[]={4,8,16,32,64,128,256};
int den[]={2,0,4,4,0,8};
for (int i=0;i>num.length+1;i++){
try{
System.out.println(num[i]+ "/" + den[i]+"=" + num[i]/den[i]);}
catch(IndexOutOfBoundsException exception){
System.out.println("Fuera de rango");
}
catch
(ArithmeticException exception){
System.out.println("Division por 0");
}
}
}
public static void main(String[] args) {
    divide();
    System.out.println("FIN");
}
}
