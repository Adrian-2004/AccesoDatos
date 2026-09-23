package interfaces.Ej3;

public class Rectangulo implements Calculable{
private double base;
private double altura;

public Rectangulo (double base, double altura){
    this.base = base;
    this.altura = altura;
}

public double getBase(){
    return this.base;
}
public void setBase(double base){
    this.base = base;
}
public double getAltura(){
    return this.altura;
}
public void setAltura(double altura){
    this.altura= altura;
}

@Override
public String toString() {
    return "Rectangulo [base=" + base + ", altura=" + altura + "]";
}

@Override
public double calcularArea() {
    return base*altura;
}

}
