package session_02.ejercicio4;
/*
Ejercicio 4: Contar Elementos del ArrayList
Descripción: Crea un programa que agregue varios números enteros a un ArrayList y
luego calcule y muestre la cantidad total de elementos en la lista.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		//Crearemos el arraylist para almacenar los numeros
		ArrayList<Integer> numeros = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int numero, cantidadElementos;
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

		//Mostrar la cantidad de elementos dentro del Arraylist
		cantidadElementos = numeros.size();
		System.out.println("\nLa cantidad de elementos del Arraylist es: " + cantidadElementos);
	}
}
