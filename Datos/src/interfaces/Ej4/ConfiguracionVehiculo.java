package interfaces.Ej4;
public interface ConfiguracionVehiculo{
    public final double MAX_VEL = 160;
    public final double MIN_VEL = 0;

public void acelerar(double incremento);
public void frenar(double disminucion);
}