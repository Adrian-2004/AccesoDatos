package POO;

public class ACamion extends AbstractoVehiculo{
	private byte numEjes;

	public ACamion(String color, byte numRuedas, short cilindrada, short potencia, byte numEjes) {
		super(color, numRuedas, cilindrada, potencia);
		this.numEjes = numEjes;
	}


public byte getNumEjes() {
		return numEjes;
	}


	public void setNumEjes(byte numEjes) {
		this.numEjes = numEjes;
	}


 double impuesto() {
	double impuesto = (getCilindrada()/30)*(getPotencia()*30);
return impuesto;
}



}
