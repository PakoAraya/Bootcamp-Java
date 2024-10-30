package dia1.ejercicio2;

//Ejercicio 2: Comparación con equals()
//1. Crea dos objetos de la clase Persona con los mismos valores de nombre y                 √
// edad.
//2. Sobreescribe el metodo equals() en Persona para que compare los objetos
// basándose en sus atributos.
//3. En el main, usa equals() para comparar los objetos y muestra el resultado.

public class Ejercicio2 {
	public static void main(String[] args) {
		Persona persona1 = new Persona("Giovanni", 34);
		Persona persona2 = new Persona("Giovanni", 34);
		//Imprimir el objeto
		System.out.println(persona1);
		System.out.println(persona2);

		//Comparar objetos
		boolean sonIguales = persona1.equals(persona2);
		System.out.println("Son Objetos iguales: " + sonIguales);

		System.out.println(persona1.getClass());
		System.out.println(persona2.getClass());

	}
}
