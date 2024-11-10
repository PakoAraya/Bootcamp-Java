package session_17.aeropuerto;

public class PistaAeropuerto {
	private boolean disponible;

	public PistaAeropuerto(boolean disponible) {
		this.disponible = disponible;
	}

	public void actualizarDisponibilidad(boolean disponible) {
		this.disponible = disponible;
		System.out.println("Disponibilidad de pista actualizada: " + (disponible ? "Disponible" : "No disponible"));
	}

	public boolean isDisponible() {
		return disponible;
	}
}