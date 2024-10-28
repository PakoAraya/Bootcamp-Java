package session_02;

import java.util.Scanner;

//Ejercicio 6: Matriz y Multiplicación por un Escalar (3pts)
//• Descripción: Crea una matriz de 2x2, permite al usuario ingresar los valores,
//luego solicita un número y multiplica todos los elementos de la matriz por ese
//número.
//• Instrucciones:
//o Usa un ciclo para recorrer la matriz y multiplicar por el escalar.

public class Ejercicio6 {
	public static void main(String[] args) {
		//Declaracion de variables
		int escalar = 0;

		//Declaracion de la matriz
		int[][] matriz = new int[2][2];
		Scanner scan = new Scanner(System.in);

		//Solicita al usuario ingresar numeros para operaciones
		System.out.println("Multiplicacion por un escalar App");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.println("Numero para [" + i + "][" + j + "]: ");
				matriz[i][j] = scan.nextInt();
			}
		}

		//Ingresar numero a multiplicar que no sea cero ni negativo
		System.out.println("Ingrese numero para multiplicar por valores de la matriz");
		escalar = scan.nextInt();

		//Multiplicar el escalar por los numeros de la matriz
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				matriz[i][j] *= escalar;
			}
		}

		//Mostrar valores nuevos de la matriz
		System.out.println("**********************************************");
		System.out.println("Valores nuevos de la matriz");
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				System.out.println("Numero para [" + i + "][" + j + "]: " + matriz[i][j]);
			}
			//System.out.println();
		}		
	}
}

