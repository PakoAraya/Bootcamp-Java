package session_17.avion;


public class Alas {
	private String largoEnMetros;
	private boolean buenEstado;

	public Alas(String largoEnMetros, boolean buenEstado) {
		this.largoEnMetros = largoEnMetros;
		this.buenEstado = buenEstado;
	}

	public void pruebaAlas() {
		System.out.println("Prueba de alas completada. Buen estado: " + buenEstado);
	}

	public boolean isBuenEstado() {
		return buenEstado;
	}
}