package session_16;

public class Main {
	public static void main(String[] args) {
		// Creación de objeto enciclopedia
		Enciclopedia enciclopedia = new Enciclopedia();

		// Crear objetos perro y gato para agregarlos a la lista
		Perro perro = new Perro("Firulais", 4, "Labrador", true);
		Gato gato = new Gato("Michi", 2, "Negro", false);

		// Agregar animales a la enciclopedia
		enciclopedia.agregarAnimal(perro);
		enciclopedia.agregarAnimal(gato);

		// Mostrar animales registrados
		enciclopedia.mostrarAnimal();
	}
}