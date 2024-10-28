package session_01;

//Ejercicio 1: Creando y Operando con un Arreglo Estático
//• Descripción: Declara un arreglo de 6 elementos enteros, asígnales valores,
//modifícalos y recórrelos usando un ciclo for y for-each.
//Instrucciones:
//1. Declara un arreglo estático de enteros de tamaño 6.
//2. Asigna los valores [1, 3, 5, 8, 9, 15] a cada índice.
//3. Modifica el valor en el índice 2, cambiándolo por 10.
//4. Recorre el arreglo e imprime cada valor en consola.

public class Ejercicio1 {
	public static void main(String[] args) {
		//Declarar el arreglo estatico 
		int[] numeros = new int[6];

		//Asignar valores dentro del arreglo
		numeros[0] = 1;
		numeros[1] = 3;
		numeros[2] = 5;
		numeros[3] = 8;
		numeros[4] = 9;
		numeros[5] = 15;

		//Vamos a recorrer con for
		for(int i=0; i < numeros.length ; i++) {		
			System.out.println("El arreglo tiene el numero: " + numeros[i] + " en la posicion i: " + i);
		}

		//Modificar el valor del indice 2.
		numeros[2] = 10;

		System.out.println("-------------------------------------------");
		System.out.println("Salida con Foreach");
		//Vamos a recorrerlo con foreach
		//  Variable     | Arreglo
		for(int elemento : numeros) {
			System.out.println("Elemento dentro del arreglo: " + elemento);
		}
	}
}
