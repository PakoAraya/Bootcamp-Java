package session_07;

import modelo.Auto;
import modelo.Bicicleta;

public class Main {
	public static void main(String[] args) {
		// Instanciar Auto
		Auto miAuto = new Auto(4, 4, "Rojo", "Toyota Corolla");
		System.out.println(miAuto);
		miAuto.encender();
		System.out.println("Tipo de bencina: " + miAuto.tipoDeBencina());
		miAuto.apagar();

		// Instanciar Bicicleta
		Bicicleta miBicicleta = new Bicicleta(2, 0, "Montaña");
		System.out.println(miBicicleta);
		miBicicleta.encender();
		miBicicleta.apagar();
	}
}