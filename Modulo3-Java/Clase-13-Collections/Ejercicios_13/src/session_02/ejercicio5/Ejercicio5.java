package session_02.ejercicio5;
/*
Ejercicio 5: Actualizar un Elemento del ArrayList
Descripción: Crea un programa que permita al usuario actualizar un valor específico
en un ArrayList. El programa debe mostrar la lista antes y después de la modificación.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		//Crearemos el arraylist para almacenar los numeros
		ArrayList<Integer> numeros = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int numero, cantidadElementos, indice, nuevoValor;
		String preguntaContinuar;

		System.out.println("******* APP para Sumar Enteros *******");
		do{
			System.out.println("Ingrese un numero entero: ");
			numero = scan.nextInt();
			numeros.add(numero);

			//Limpiar el Scanner
			scan.nextLine();

			//Preguntar al usuario si quiere continuar
			System.out.println("Quieres agregar otro numero??? (si/no): ");
			preguntaContinuar = scan.nextLine().toLowerCase();
		}while(preguntaContinuar.equals("si"));

		//Mostrar la lista actual de valores
		System.out.println("\nLos valores de la lista son: ");
		for (int i=0; i<numeros.size(); i++) {
			System.out.println(i + ": " + numeros.get(i));
		}

		//Pedir al usuario que numero desea actualizar
		System.out.println("\nQue numero deseas actualizar: ");
		indice = scan.nextInt();
		//Comprobamos que el indice este dentro del rango de numeros
		if(indice >= 0 && indice < numeros.size()){
			System.out.println("Ingresa el nuevo valor a actualizar: ");
			nuevoValor = scan.nextInt();
			numeros.set(indice, nuevoValor);

			//Mostrar la lista actual de valores
			System.out.println("\nLos valores de la lista son: ");
			for (int i=0; i<numeros.size(); i++) {
				System.out.println(i + ": " + numeros.get(i));
			}

		}else {
			System.out.println("\nIndice ingresado no valido. No se realizo ninguna actualizacion...");
		}

	}
}
