package ejerciciosPruebas;

public class MiClase {


	public boolean esPar(int numero) {
		return numero % 2 == 0;
	}


	public int multiplicar(int a, int b) {
		return a * b;
	}


	public String obtenerSaludo(String nombre) {
		return "Hola, " + nombre;
	}


	public String obtenerValorNulo() {
		return null;
	}

	public Persona crearPersona(String nombre, int edad) {
		return new Persona(nombre, edad);
	}

	public double calcularCuadrado(double numero) {
		return numero * numero;
	}


	public boolean esCadenaVacia(String cadena) {
		return cadena == null || cadena.isEmpty();
	}
}