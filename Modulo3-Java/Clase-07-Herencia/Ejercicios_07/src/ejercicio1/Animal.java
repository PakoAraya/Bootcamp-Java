package ejercicio1;

//Clase padre Animal
public class Animal {
	// Atributos privados
	private String nombre;
	private int edad;

	// Constructor
	public Animal(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	// Métodos protected hacerSonido() que imprime un mensaje genérico
	protected void hacerSonido() {
		System.out.println("El animal hace un sonido.");
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
