package evaluacion;

public class Persona {
	private String nombre;
	private int edad;
	private double peso;  // en kilogramos
	private double altura;  // en metros

	// Constructor
	public Persona(String nombre, int edad, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
	}

	// Getters para los atributos
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	// Método para calcular el IMC
	public double calcularIMC() {
		return peso / (altura * altura);  // IMC = peso / altura^2
	}

	// Método para verificar si es mayor de edad
	public boolean esMayorDeEdad() {
		return edad >= 18;
	}

	// Método toString para imprimir los detalles de la persona
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Edad: " + edad + " años, Peso: " + peso + " kg, Altura: " + altura + " m";
	}
}
