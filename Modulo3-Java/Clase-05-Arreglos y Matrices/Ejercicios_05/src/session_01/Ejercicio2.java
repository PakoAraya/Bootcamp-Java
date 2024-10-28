package session_01;

//Ejercicio 2: Arreglos Multidimensionales
//• Descripción: Declara una matriz de 3x3, asigna valores, y recórrela utilizando
//ciclos for anidados.
//Instrucciones:
//1. Declara una matriz de enteros de 3x3.
//2. Asigna los valores 1 a 9 a cada posición de la matriz.
//3. Imprime la matriz recorriéndola con ciclos for anidados.

public class Ejercicio2 {
	public static void main(String[] args) {
		//Declaracion de matriz o arreglo bidimensional
		int[][] matriz = new int[3][3];

		//Asignacion de valores.
		//	matriz[0][1] = 1; matriz[0][1] = 2; matriz[0][2] = 3;
		//	matriz[1][0] = 4; matriz[1][1] = 5; matriz[1][2] = 6;
		//	matriz[2][0] = 7; matriz[2][1] = 8; matriz[2][2] = 9;

		//Otra forma de llenado automatico
		int valor = 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = valor++;
			}
		}
		//Imprimendo los valores de la matriz
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println("Elemento en [i - " + i + "][j - " + j +"] = " + matriz[i][j] );
			}
		}
	}
}

