package POO;

public class AMotocicleta extends AbstractoVehiculo{
private byte NumeroDePlazas;

public AMotocicleta(String color, byte numRuedas, short cilindrada, short potencia, byte NumeroDePlazas) {
	super(color, numRuedas, cilindrada, potencia);
	this.NumeroDePlazas = NumeroDePlazas;
}
public double impuesto () {
	return 0;
}
public byte getNumeroDePlazas() {
	return NumeroDePlazas;
}
public void setNumeroDePlazas(byte numeroDePlazas) {
	NumeroDePlazas = numeroDePlazas;
}


}
