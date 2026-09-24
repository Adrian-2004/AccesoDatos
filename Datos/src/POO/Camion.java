package POO;

public class Camion extends Vehiculo{
private byte numEjes;

public Camion(String color, byte numRuedas, short cilindrada, short potencia, byte numEjes) {
	super(color, numRuedas, cilindrada, potencia);
	this.numEjes = numEjes;
}

public byte getNumEjes() {
	return numEjes;
}

public void setNumEjes(byte numEjes) {
	this.numEjes = numEjes;
}

}
