package session_16;

import java.util.ArrayList;
import java.util.List;

public class Enciclopedia {
	private List<Animal> animales;

	// Constructor de la clase
	public Enciclopedia() {
		this.animales = new ArrayList<>();
	}

	// Agregar un animal a la lista de objetos animales
	public void agregarAnimal(Animal animal) {
		animales.add(animal);
	}

	// Mostrar animales registrados
	public void mostrarAnimal() {
		for (Animal animal : animales) {
			System.out.println(animal.hacerSonido());
		}
	}
}