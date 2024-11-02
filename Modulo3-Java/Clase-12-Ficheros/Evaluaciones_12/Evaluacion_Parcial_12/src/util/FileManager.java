package util;

import modelo.Participante;
import java.io.*;
import java.util.List;

public class FileManager {
	private static final String PARTICIPANTES_FILE = "participantes.txt";
	private static final String GANADOR_FILE = "ganador.txt";

	public void cargarParticipantes(List<Participante> participantes) {
		try (BufferedReader br = new BufferedReader(new FileReader(PARTICIPANTES_FILE))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				participantes.add(new Participante(linea));
			}
		} catch (IOException e) {
			System.out.println("No se pudo cargar la lista de participantes. Se creará una nueva.");
		}
	}

	public void guardarParticipantes(List<Participante> participantes) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(PARTICIPANTES_FILE))) {
			for (Participante participante : participantes) {
				bw.write(participante.getNombre());
				bw.newLine();
			}
			System.out.println("Lista de participantes guardada correctamente.");
		} catch (IOException e) {
			System.out.println("Error al guardar la lista de participantes.");
		}
	}

	public void guardarGanador(Participante ganador) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(GANADOR_FILE))) {
			bw.write("¡Felicidades " + ganador.getNombre() + "!");
			bw.newLine();
			bw.write("Has ganado una bicicleta en el concurso.");
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo del ganador.");
		}
	}
}