package Excepciones;

public class excepciones1 {
   
   public static void miMetodo(){

       try{
           int numero[] = new int[5];
           int resultado = numero[7]/0;
           System.out.println(resultado);
           
        }catch (IndexOutOfBoundsException excep){
            System.out.println("Ocurrio una excepcion");
        }
  
}

}