package servicio;

import modelo.Participante;
import java.util.List;
import java.util.Random;

public class GanadorSelector {
	public Participante elegirGanador(List<Participante> participantes) {
		if (participantes.isEmpty()) {
			return null;
		}
		Random random = new Random();
		return participantes.get(random.nextInt(participantes.size()));
	}
}