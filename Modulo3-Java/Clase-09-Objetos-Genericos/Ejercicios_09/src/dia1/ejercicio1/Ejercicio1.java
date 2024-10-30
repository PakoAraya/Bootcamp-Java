package dia1.ejercicio1;

//Ejercicio 1: Sobreescribir toString()
//1. Crea una clase Persona con atributos nombre y edad.
//2. Sobreescribe el metodo toString() para que devuelva una cadena con los
// valores de nombre y edad.
//3.En el main, crea un objeto Persona, imprímelo y observa la salida.

public class Ejercicio1 {
	public static void main(String[] args) {
		Persona persona1 = new Persona("Giovanni", 34);
		//Imprimir el objeto
		System.out.println(persona1);
	}
}
