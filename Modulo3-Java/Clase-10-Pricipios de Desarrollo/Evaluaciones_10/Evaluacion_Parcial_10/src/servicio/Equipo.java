package servicio;

import modelo.DirectorTecnico;
import modelo.Jugador;
import java.util.List;

public class Equipo {
	private DirectorTecnico directorTecnico;
	private List<Jugador> jugadoresTitulares;

	public Equipo(DirectorTecnico directorTecnico, List<Jugador> jugadoresTitulares) {
		this.directorTecnico = directorTecnico;

		if (jugadoresTitulares.size() <= 11) {
			this.jugadoresTitulares = jugadoresTitulares;
		} else {
			throw new IllegalArgumentException("El equipo no puede tener más de 11 jugadores titulares.");
		}
	}

	public void mostrarEquipo() {
		System.out.println("Director Técnico: " + directorTecnico);
		System.out.println("Jugadores Titulares:");
		for (Jugador jugador : jugadoresTitulares) {
			System.out.println(jugador);
		}
	}
}