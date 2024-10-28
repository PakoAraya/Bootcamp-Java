package ejercicio1;

//Clase hija Perro que hereda de Animal
public class Perro extends Animal {
	// Atributo privado adicional
	private String raza;

	// Constructor
	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		this.raza = raza;
	}

	// Sobrescribe el metodo hacerSonido()
	@Override
	protected void hacerSonido() {
		// Llama al metodo de la clase padre
		super.hacerSonido();
		// Comportamiento adicional
		System.out.println("El perro ladra: ¡Guau guau!");
	}

	// Getters y Setters
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
}