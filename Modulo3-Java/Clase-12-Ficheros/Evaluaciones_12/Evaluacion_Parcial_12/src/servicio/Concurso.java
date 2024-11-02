package servicio;

import modelo.Participante;
import util.FileManager;
import java.util.Scanner;

public class Concurso {
	private ParticipanteManager participanteManager;
	private GanadorSelector ganadorSelector;
	private FileManager fileManager;

	public Concurso(ParticipanteManager participanteManager, GanadorSelector ganadorSelector, FileManager fileManager) {
		this.participanteManager = participanteManager;
		this.ganadorSelector = ganadorSelector;
		this.fileManager = fileManager;
	}

	public void iniciar() {
		fileManager.cargarParticipantes(participanteManager.getParticipantes());
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			System.out.println("\nMenú del Concurso:");
			System.out.println("1. Agregar un nuevo participante");
			System.out.println("2. Ver lista de participantes");
			System.out.println("3. Elegir al ganador");
			System.out.println("4. Salir");

			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la nueva línea

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el nombre del participante: ");
				String nombre = scanner.nextLine();
				participanteManager.agregarParticipante(nombre);
				break;
			case 2:
				participanteManager.mostrarParticipantes();
				break;
			case 3:
				Participante ganador = ganadorSelector.elegirGanador(participanteManager.getParticipantes());
				if (ganador != null) {
					System.out.println("¡El ganador es " + ganador.getNombre() + "!");
					fileManager.guardarGanador(ganador);
				} else {
					System.out.println("No hay participantes registrados.");
				}
				fileManager.guardarParticipantes(participanteManager.getParticipantes());
				continuar = false;
				break;
			case 4:
				fileManager.guardarParticipantes(participanteManager.getParticipantes());
				continuar = false;
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
			}
		}

		scanner.close();
	}
}