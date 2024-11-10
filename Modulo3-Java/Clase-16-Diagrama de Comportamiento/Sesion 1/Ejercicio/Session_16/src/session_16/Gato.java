package session_16;

class Gato extends Animal {
	private String colorDePelo;
	private boolean estaDesungulado;

	public Gato(String nombre, int edad, String colorDePelo, boolean estaDesungulado) {
		super(nombre, edad);
		this.colorDePelo = colorDePelo;
		this.estaDesungulado = estaDesungulado;
	}

	@Override
	public String hacerSonido() {
		return nombre + " dice: ¡Miau!";
	}
}