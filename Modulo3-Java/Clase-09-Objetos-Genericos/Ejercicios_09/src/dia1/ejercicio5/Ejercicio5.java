package dia1.ejercicio5;

//Ejercicio 5: Sobreescribir toString() y equals()
//1. Crea una clase Libro con atributos titulo y autor.
//2. Sobreescribe toString() para devolver una representación legible de Libro.
//3. Sobreescribe equals() para que dos libros con el mismo titulo y autor se
//consideren iguales.
//4. En el main, crea dos libros con los mismos valores y compara su igualdad.

public class Ejercicio5 {
	public static void main(String[] args) {
		//Creando objetos con valores identicos
		Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R Tolkien");
		Libro libro2 = new Libro("El Señor de los Anillos", "J.R.R Tolkien");

		//Imprimiendo los objetos
		System.out.println("Datos libro1 = " + libro1);
		System.out.println("Datos libro2 = " + libro2);

		//Comparacion de los objetos
		boolean sonIgueles = libro1.equals(libro2);
		//Imprimiendo el resultado de la comparacion
		System.out.println("Los libros son iguales = " + sonIgueles);
	}
}
