package session_17.avion;

public class Motores {
	private boolean tieneCombustible;
	private boolean buenEstado;

	public Motores(boolean buenEstado) {
		this.buenEstado = buenEstado;
		this.tieneCombustible = false; // Inicialmente sin combustible
	}

	public void cargarCombustible() {
		this.tieneCombustible = true;
		System.out.println("Combustible cargado. Buen estado: " + buenEstado);
	}

	public boolean isBuenEstado() {
		return buenEstado && tieneCombustible;
	}
}