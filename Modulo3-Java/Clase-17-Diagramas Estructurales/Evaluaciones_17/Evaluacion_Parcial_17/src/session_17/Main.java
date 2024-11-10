package session_17;

import session_17.aeropuerto.PistaAeropuerto;
import session_17.avion.Alas;
import session_17.avion.Avion;
import session_17.avion.Cabina;
import session_17.avion.Motores;
import session_17.avion.Ruedas;

public class Main {
	public static void main(String[] args) {
		// Crear componentes del avión
		Alas alas = new Alas("30 metros", true);
		Motores motores = new Motores(true);
		Ruedas ruedas = new Ruedas(true);
		Cabina cabina = new Cabina(150, 4, true);

		// Crear avión con sus componentes
		Avion avion = new Avion("Boeing", "747", alas, motores, ruedas, cabina);

		// Crear pista de aeropuerto
		PistaAeropuerto pista = new PistaAeropuerto(true);

		// Ejecutar rutina de chequeo de seguridad
		if (pista.isDisponible()) {
			avion.recibirPasajeros();
			avion.realizarChequeoCompleto();
			avion.despegar();
		} else {
			System.out.println("La pista no está disponible para despegue.");
		}
	}
}