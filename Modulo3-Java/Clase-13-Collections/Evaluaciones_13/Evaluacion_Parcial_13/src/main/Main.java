package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	// Método para leer valores desde el teclado
	public static ArrayList<Integer> leerValores() {
		ArrayList<Integer> valores = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int numero;

		System.out.println("Introduce valores enteros (termina con -99):");

		while (true) {
			numero = scanner.nextInt();
			if (numero == -99) break;  // Fin de la lectura
			valores.add(numero);  // Agregar el número a la lista
		}

		return valores;
	}

	// Método para calcular la suma usando un Iterator
	public static int calcularSuma(ArrayList<Integer> valores) {
		int suma = 0;
		Iterator<Integer> iterator = valores.iterator();

		while (iterator.hasNext()) {
			suma += iterator.next();
		}

		return suma;
	}

	// Método para mostrar los resultados
	public static void mostrarResultados(ArrayList<Integer> valores, int suma, double media) {
		System.out.println("Valores ingresados: " + valores);
		System.out.println("Suma de los valores: " + suma);
		System.out.println("Media aritmética: " + media);

		int mayores = 0;
		int menores = 0;

		for (int valor : valores) {
			if (valor > media) {
				mayores++;
			} else if (valor < media) {
				menores++;
			}
		}

		System.out.println("Cantidad de valores mayores a la media: " + mayores);
		System.out.println("Cantidad de valores menores a la media: " + menores);
	}

	public static void main(String[] args) {
		ArrayList<Integer> valores = leerValores();
		int suma = calcularSuma(valores);
		double media = suma / (double) valores.size();

		mostrarResultados(valores, suma, media);
	}
}