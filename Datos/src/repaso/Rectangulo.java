package repaso;

public class Rectangulo {
private int alto = 1;
private int ancho = 1;
public Rectangulo(int alto, int ancho){
  setAlto(alto);
  setAncho(ancho);
}
public int getAlto(){
    return alto;
}
public void setAlto(int alto){
    if(alto>=2){
        this.alto=alto;
    }
}
public int getAncho(){
    return ancho;
}
public void setAncho(int ancho){
    if(ancho>0){
        this.ancho=ancho;
    }
}
public double area(){
    return alto*ancho;
}
public double perimetro(){
    return 2*(alto+ancho);
}
}
