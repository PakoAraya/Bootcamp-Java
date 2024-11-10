package session_16;

abstract class Animal {
	protected String nombre;
	protected int edad;

	public Animal(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public abstract String hacerSonido();

	@Override
	public String toString() {
		return nombre + " (" + edad + " años)";
	}
}