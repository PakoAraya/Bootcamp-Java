package session_05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Creando los arreglos unidimensionales
		String[] asignaturas = new String[5];
		double[] promedios = new double[5];

		//Solicitar el nombre de las asignaturas y el promedio
		for (int i=0; i<5; i++) {
			System.out.println("Ingrese el nombre de la asignatura " + (i+1) + ": ");
			asignaturas[i] = scan.nextLine();
			System.out.println("Ingrese el promedio de la asignatura " + asignaturas[i] + ": ");
			promedios[i] = scan.nextDouble();
			scan.nextLine();
		}

		//Calcular el promedio final
		double promedioFinal = 0;
		for (int i=0; i<5; i++) {
			promedioFinal += promedios[i];
		}
		promedioFinal /= 5;

		//Mostrar los promedios por asignatura
		System.out.println("Promedios por asignatura:");
		for (int i=0; i< 5; i++) {
			System.out.println(asignaturas[i] + ": " + promedios[i]);
		}

		//Mostrar el promedio final
		System.out.printf("El promedio final de todas las asignaturas es: %.2f%n", promedioFinal);

		scan.close();		
	}
}