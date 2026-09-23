package repaso;

public class TestRectangulo {
public static void main(String[] args) {
    Rectangulo rect1 = new Rectangulo(2, 2);
    System.out.println("Area: "+rect1.area());
    System.out.println("Perímetro: "+rect1.perimetro());
    
    rect1.setAlto(3);
    rect1.setAncho(6);
    System.out.println("Area 2: "+rect1.area());
    System.out.println("Perímetro 2: "+rect1.perimetro());

    rect1.setAlto(-4);
    rect1.setAncho(0);
    System.out.println("Area 3: "+rect1.area());
    System.out.println("Perímetro 3: "+rect1.perimetro());

    Rectangulo rect2 = new Rectangulo(4, 4);
    System.out.println("Area rect2: "+rect2.area());
    System.out.println("Perímetro rect2: "+rect2.perimetro());

    /*c) El valor no cambia porque al crear un rectangulo con new se crea un objeto independiente, y el modificador this, refiere a los atributos
    de la instancia actual creada 
    d) El unico cambio esta en el if dentro del metodo setAlto(), nada mas */
}
}
