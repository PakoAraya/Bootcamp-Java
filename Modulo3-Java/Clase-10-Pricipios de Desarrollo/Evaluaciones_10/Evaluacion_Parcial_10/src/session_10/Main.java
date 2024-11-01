package session_10;

import modelo.DirectorTecnico;
import modelo.Jugador;
import servicio.Equipo;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Crear Director Técnico y jugadores
		DirectorTecnico dt = new DirectorTecnico("Carlos", "López", 55, 20);

		List<Jugador> jugadores = new ArrayList<>();
		jugadores.add(new Jugador("Juan", "Pérez", 28, 10, "Delantero"));
		jugadores.add(new Jugador("Luis", "García", 24, 5, "Defensa"));
		// Agrega hasta 11 jugadores

		// Crear equipo
		Equipo equipo = new Equipo(dt, jugadores);

		// Mostrar equipo
		equipo.mostrarEquipo();

		// Probar acciones de los jugadores y del director técnico
		System.out.println("\nPruebas de acciones del director técnico:");
		dt.hablar();
		dt.celebrar();
		dt.recibirTarjetaAmarilla();
		dt.recibirTarjetaRoja();

		System.out.println("\nPruebas de acciones de un jugador:");
		Jugador jugador = jugadores.get(0);  // Selecciona un jugador de la lista
		jugador.hablar();
		jugador.celebrar();
		jugador.correr();
		jugador.saltar();
		jugador.quitarBalon();
		jugador.recibirTarjetaAmarilla();
		jugador.recibirTarjetaRoja();
	}
}