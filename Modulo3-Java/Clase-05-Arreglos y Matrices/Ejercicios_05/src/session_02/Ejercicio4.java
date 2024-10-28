package session_02;

import java.util.Scanner;

//Ejercicio 4: Matriz de Números y Suma de Filas (2pts)
//• Descripción: Crea una matriz de 3x3, permite al usuario ingresar los valores y
//luego calcula la suma de cada fila.
//• Instrucciones:
//o Recorrer la matriz usando ciclos anidados.

public class Ejercicio4 {
	public static void main(String[] args) {
		//Declaracion de variables
		int suma;
		int[][] matriz = new int[3][3];
		Scanner scan = new Scanner(System.in);

		//Ingresar los valores dentro de la matriz
		//Ingresar las notas
		System.out.println("Suma Matriz APP");
		System.out.println("Por favor ingrese los valores de la matriz");
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				System.out.println("Elemento [" + i + "][" + j + "]: ");
				matriz[i][j] = scan.nextInt();
			}
		}

		//Ciclos para sumar.
		for(int i=0; i<matriz.length; i++) {
			suma = 0;
			for(int j=0; j<matriz[i].length; j++) {
				suma += matriz[i][j];
			}
			System.out.println("************************************************************");
			System.out.println("La suma de la posicion [" + (i+1) + "] es: " + suma);
		}
	}
}

