package POO;

public class Motocicleta extends Vehiculo{
private byte numPlazas;

	public Motocicleta(String color, byte numRuedas, short cilindrada, short potencia, byte numPlazas) {
		super(color, numRuedas, cilindrada, potencia);
		this.numPlazas = numPlazas;
	}
	public byte getNumPlazas() {
	return numPlazas;
}
public void setNumPlazas(byte numPlazas) {
	this.numPlazas = numPlazas;
}
}
