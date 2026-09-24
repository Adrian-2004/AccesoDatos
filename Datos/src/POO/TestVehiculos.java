package POO;

public class TestVehiculos {
public static void main(String[] args) {
	Motocicleta moto1 = new Motocicleta("rojo", (byte)2, (short)125, (short)25,(byte) 2);
	Motocicleta moto2 = new Motocicleta("Rojo", (byte) 4,(short) 100, (short) 30, (byte)2);
	
	Camion camion1 = new Camion("Rojo",(byte) 6, (short)4000, (short)300, (byte)2);
	Camion camion2 = new Camion("Verde", (byte) 10, (short) 8000, (short) 500, (byte)3);
	
	moto1.setNumPlazas((byte)1);
	System.out.println(moto1.getNumPlazas());
	System.out.println(moto2.getNumPlazas());
	System.out.println(camion2.getPotencia());
	System.out.println(camion1.getNumEjes());
 }
}
