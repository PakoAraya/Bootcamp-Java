package session_02;

import java.util.Scanner;

//Ejercicio 9: Matriz de Notas y Promedio por Fila (3pts)
//• Descripción: Crea una matriz de 3x3 para almacenar las notas de 3
//estudiantes en 3 exámenes. Luego, calcula el promedio de notas por
//estudiante.
//• Instrucciones:
//o Recorrer la matriz y calcular el promedio por fila.

public class Ejercicio9 {
	public static void main(String[] args) {
		//Declaracion de variables
		double suma, promedio;
		double[][] notas = new double[3][3];
		Scanner scan = new Scanner(System.in);

		//Ingresar las notas
		System.out.println("NotasAPP");
		System.out.println("Por favor ingrese las notas de las 3 evaluaciones");
		for(int i=0; i<notas.length; i++) {
			suma = 0;
			for(int j=0; j<notas[i].length; j++) {
				System.out.println("Ingrese la nota " + (j+1) +" del alumno " + (i+1));
				notas[i][j] = scan.nextDouble(); 
				suma += notas[i][j];
			}
			//promedio = suma / 3;
			promedio = suma / notas[i].length;
			System.out.println("****************************************************");
			System.out.println("Promedio del alumno " + (i+1) + " : " + promedio);
			System.out.println("****************************************************");
		}


	}
}
