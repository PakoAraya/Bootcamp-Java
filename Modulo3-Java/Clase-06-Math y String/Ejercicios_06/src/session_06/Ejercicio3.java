package session_06;

//Ejercicio 3: Generador de Números Aleatorios Sin Repetición
//Descripción: Crea un programa que genere un conjunto de números aleatorios (entre
//1 y 100) sin repetición y los almacene en un arreglo. El programa debe usar
//Math.random() para generar los números y verificar si el número ya existe en el arreglo
//antes de agregarlo. Además, el programa debe permitir al usuario definir cuántos
//números aleatorios quiere generar.

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cantidad = 0, contador = 0, num_aleatorio = 0;

		System.out.println("RanDomNumber APP");
		System.out.print("Por favor ingrese cuántos números al azar quiere entre 1 y 100: ");
		cantidad = scan.nextInt();

		// Verificar que la cantidad esté en el rango permitido
		if (cantidad >= 1 && cantidad <= 100) {
			System.out.println("Rango de números válido");
		} else {
			System.out.println("Rango de números inválido");
			return; // Salir si el rango no es válido
		}

		// Inicializar el arreglo con la cantidad indicada por el usuario
		int[] numeros = new int[cantidad];

		// Aquí se ingresan los números aleatorios
		while (contador < cantidad) {
			// Generar número aleatorio
			num_aleatorio = (int) (Math.random() * 100 + 1);
			System.out.print(num_aleatorio + " | ");

			// Comprobar que el número no esté en el arreglo
			boolean repetido = false; // Inicializar como no repetido
			for (int i = 0; i < contador; i++) {
				if (numeros[i] == num_aleatorio) {
					System.out.println("Número repetido: " + num_aleatorio);
					repetido = true; // Marcar como repetido
					break; // Salir del bucle si encuentra repetición
				}
			}

			// Si no se encuentra el número repetido, agregarlo al arreglo
			if (!repetido) {
				numeros[contador] = num_aleatorio; // Agregar el número al arreglo
				contador++; // Incrementar el contador solo si se agregó un número nuevo
			}
		}

		// Mostrar el arreglo con números usando foreach
		System.out.println("\nNúmeros generados sin repetición:");
		for (int numero : numeros) {
			System.out.print(numero + " | ");
		}
	}
}