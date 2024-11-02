package App;

import servicio.Concurso;
import servicio.GanadorSelector;
import servicio.ParticipanteManager;
import util.FileManager;

public class Main {
	public static void main(String[] args) {
		ParticipanteManager participanteManager = new ParticipanteManager();
		GanadorSelector ganadorSelector = new GanadorSelector();
		FileManager fileManager = new FileManager();

		Concurso concurso = new Concurso(participanteManager, ganadorSelector, fileManager);
		concurso.iniciar();
	}
}