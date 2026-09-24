package interfaces.Ej3;

public class Main {
public static void main(String[] args) {
    Circulo circ1 = new Circulo(2);
    Circulo circ2 = new Circulo(10);

    Rectangulo rect1 = new Rectangulo(2, 4);
    Rectangulo rect2 = new Rectangulo(5, 10);

    System.out.println("Area rectangulo 1 = "+rect1.calcularArea());
    System.out.println("Area rectangulo 2 = "+rect2.calcularArea());
    System.out.println("Area Circulo 1 = "+circ1.calcularArea());
    System.out.println("Area Circulo 2 = "+circ2.calcularArea());
}
}
