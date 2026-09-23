package interfaces.Ej4;

public class Coche implements ConfiguracionVehiculo{

    private double velocidadActual;

    public Coche(double velocidadActual){
        this.velocidadActual = velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual){
        this.velocidadActual=velocidadActual;
    }

    public double getVelocidadActual(){
        return velocidadActual;
    }

public void acelerar(double incremento){
   this.velocidadActual+=incremento;
   if (this.velocidadActual>MAX_VEL) {
    this.velocidadActual = MAX_VEL;
    
   }
}

public void frenar(double disminucion){
  this.velocidadActual-=disminucion;
  if (this.velocidadActual<MIN_VEL) {
    this.velocidadActual=MIN_VEL;
    
  }
}

@Override
public String toString() {
    return "Coche [velocidadActual=" + velocidadActual + "]";
}

}
