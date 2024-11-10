package session_17.avion;

public class Ruedas {
	private boolean infladas;
	private boolean buenEstado;

	public Ruedas(boolean buenEstado) {
		this.buenEstado = buenEstado;
		this.infladas = false; // Inicialmente no infladas
	}

	public void inflar() {
		this.infladas = true;
		System.out.println("Ruedas infladas. Buen estado: " + buenEstado);
	}

	public boolean isBuenEstado() {
		return buenEstado && infladas;
	}
}