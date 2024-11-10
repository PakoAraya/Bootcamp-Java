package session_16;

class Perro extends Animal {
	private String raza;
	private boolean estaEntrenado;

	public Perro(String nombre, int edad, String raza, boolean estaEntrenado) {
		super(nombre, edad);
		this.raza = raza;
		this.estaEntrenado = estaEntrenado;
	}

	@Override
	public String hacerSonido() {
		return nombre + " dice: ¡Guau!";
	}
}