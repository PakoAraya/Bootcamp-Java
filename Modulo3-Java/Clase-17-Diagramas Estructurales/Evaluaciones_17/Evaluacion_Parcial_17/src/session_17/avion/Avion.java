package session_17.avion;

public class Avion {
	private String marca;
	private String modelo;
	private boolean listoParaDespegar;
	private Alas alas;
	private Motores motores;
	private Ruedas ruedas;
	private Cabina cabina;

	public Avion(String marca, String modelo, Alas alas, Motores motores, Ruedas ruedas, Cabina cabina) {
		this.marca = marca;
		this.modelo = modelo;
		this.alas = alas;
		this.motores = motores;
		this.ruedas = ruedas;
		this.cabina = cabina;
	}

	public void recibirPasajeros() {
		System.out.println("Pasajeros abordando...");
	}

	public void despegar() {
		if (listoParaDespegar) {
			System.out.println("El avión está despegando.");
		} else {
			System.out.println("El avión no está listo para despegar.");
		}
	}

	public void realizarChequeoCompleto() {
		alas.pruebaAlas();
		motores.cargarCombustible();
		ruedas.inflar();
		cabina.cerrarPuertas();
		listoParaDespegar = alas.isBuenEstado() && motores.isBuenEstado() && ruedas.isBuenEstado() && cabina.isBuenEstado();
		System.out.println("Chequeo completo. Listo para despegar: " + listoParaDespegar);
	}
}