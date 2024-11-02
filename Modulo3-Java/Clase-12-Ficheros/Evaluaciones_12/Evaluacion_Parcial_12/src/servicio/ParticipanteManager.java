package servicio;

import modelo.Participante;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteManager {
	private List<Participante> participantes = new ArrayList<>();

	public void agregarParticipante(String nombre) {
		participantes.add(new Participante(nombre));
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void mostrarParticipantes() {
		System.out.println("\nLista de Participantes:");
		for (int i = 0; i < participantes.size(); i++) {
			System.out.println((i + 1) + ". " + participantes.get(i).getNombre());
		}
	}
}