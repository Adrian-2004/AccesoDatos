package interfaces.Ej4;

public class Test {
public static void main(String[] args) {
    Coche coche = new Coche(60);
    Coche coche2 = new Coche(130);
  
    System.out.println("coche1: 60km/h "+coche.toString());
    coche.acelerar(30);
   System.out.println("coche1 +30 km/h: "+coche.toString());
   coche.frenar(100);
   System.out.println("coche1 -100 km/h: "+coche.toString());

   System.out.println("coche2: 130km/h"+coche2.toString());
   coche.acelerar(40);
   System.out.println("coche2: +40 km/h"+coche2.toString());
   coche.frenar(40);
   System.out.println("coche2: -40 km/h"+coche2.toString());
}
}
