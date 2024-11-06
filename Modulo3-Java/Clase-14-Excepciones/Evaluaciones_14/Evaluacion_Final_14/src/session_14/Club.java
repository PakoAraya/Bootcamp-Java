package session_14;

import java.util.ArrayList;
import java.util.List;

public class Club {
	private static final int LIMITE_SOCIOS = 7;
	private List<Socio> socios = new ArrayList<>();

	public void agregarSocio(Socio nuevoSocio) throws Exception {
		if (socios.size() >= LIMITE_SOCIOS) {
			throw new Exception("Error: No se pueden agregar más socios. El club ya tiene " + LIMITE_SOCIOS + " miembros.");
		}
		if (socios.contains(nuevoSocio)) {
			throw new Exception("Error: Este socio ya está registrado en el club.");
		}
		socios.add(nuevoSocio);
		System.out.println("Socio agregado exitosamente: " + nuevoSocio);
	}

	public void mostrarSocios() {
		if (socios.isEmpty()) {
			System.out.println("No hay socios en el club.");
		} else {
			socios.forEach(System.out::println);
		}
		System.out.println("Total de socios en el club: " + socios.size());
	}
}
