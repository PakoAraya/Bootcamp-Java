package session_17.avion;


public class Cabina {
	private int capacidadPasajeros;
	private int numeroPuertas;
	private boolean puertasCerradas;
	private boolean buenEstado;

	public Cabina(int capacidadPasajeros, int numeroPuertas, boolean buenEstado) {
		this.capacidadPasajeros = capacidadPasajeros;
		this.numeroPuertas = numeroPuertas;
		this.buenEstado = buenEstado;
		this.puertasCerradas = false; // Inicialmente abiertas
	}

	public void cerrarPuertas() {
		this.puertasCerradas = true;
		System.out.println("Puertas cerradas. Buen estado: " + buenEstado);
	}

	public boolean isBuenEstado() {
		return buenEstado && puertasCerradas;
	}
}