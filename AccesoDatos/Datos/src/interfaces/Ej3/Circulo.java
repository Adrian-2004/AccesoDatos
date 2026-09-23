package interfaces.Ej3;

public class Circulo implements Calculable{
private double radio;

public Circulo(double radio){
    this.radio = radio;
}
public double getRadio(){
    return this.radio;
}
public void setRadio(double radio){
 this.radio = radio;   
}
@Override
public String toString() {
    return "Circunferencia [radio=" + radio + "]";
}
@Override
public double calcularArea() {
    return Math.PI*Math.pow(radio, 2);
}

}
