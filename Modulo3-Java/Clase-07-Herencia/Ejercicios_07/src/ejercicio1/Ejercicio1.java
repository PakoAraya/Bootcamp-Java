package ejercicio1;

//Ejercicio 1: Clase Animal y Clase Perro
//Enunciado:
//Crea una clase padre llamada Animal que tenga un metodo hacerSonido(), el cual
//imprime un mensaje genérico. Luego, crea una clase hija llamada Perro que
//sobrescriba el metodo hacerSonido() y lo complemente con un comportamiento
//adicional, pero que también invoque el metodo de la clase padre usando super.

public class Ejercicio1 {
	public static void main(String[] args) {
		// Crear una instancia de Perro
		Perro miPerro = new Perro("Firulais", 3, "Labrador");

		// Usar los getters para obtener los valores
		System.out.println("Nombre: " + miPerro.getNombre());
		System.out.println("Edad: " + miPerro.getEdad());
		System.out.println("Raza: " + miPerro.getRaza());

		// Llamar al metodo hacerSonido()
		miPerro.hacerSonido();

		// Usar los setters para cambiar los valores
		miPerro.setNombre("Rex");
		miPerro.setEdad(4);
		miPerro.setRaza("Pastor Alemán");

		// Mostrar los nuevos valores
		System.out.println("Nuevo Nombre: " + miPerro.getNombre());
		System.out.println("Nueva Edad: " + miPerro.getEdad());
		System.out.println("Nueva Raza: " + miPerro.getRaza());
	}
}
