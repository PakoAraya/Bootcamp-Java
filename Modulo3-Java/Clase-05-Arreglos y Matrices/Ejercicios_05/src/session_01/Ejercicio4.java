package session_01;

import java.util.Scanner;

//Ejercicio 4: Modificar Elementos en una Matriz
//• Descripción: Crea una matriz de 2x3, permite al usuario modificar un valor de
//la matriz ingresando la fila y columna, y luego imprime la matriz actualizada.
//Instrucciones:
//1. Declara una matriz de 2x3 con valores iniciales.
//2. Permite al usuario ingresar la fila, columna y nuevo valor.
//3. Actualiza la matriz con el valor ingresado.
//4. Imprime la matriz actualizada.

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//Matriz con valores iniciales
		int[][] matriz = new int[2][3];
		matriz[0][0] = 9; matriz[0][1] = 2; matriz[0][2] = 7;
		matriz[1][0] = 5; matriz[1][1] = 8; matriz[1][2] = 3;
		int fila, columna, numero_nuevo;

		System.out.println("Impresion matriz original");
		//		for (int i = 0; i < matriz.length; i++) {
		//			for (int j = 0; j < matriz[i].length; j++) {
		//				System.out.println("[i " + i + "][j " + j + "] = " + matriz[i][j]);
		//			}
		//		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " | "); // Espacio entre los números
			}
			System.out.println(); // Salto de línea después de cada fila
		}
		System.out.println("**************************************************");
		System.out.println("Ingrese las coordenadas del numero que quiere cambiar (Fila y Columna)");
		System.out.println("Ingrese la posicion de la fila que quiere cambiar: ");
		fila = scan.nextInt();
		System.out.println("Ingrese la posicion de la columna que quiere cambiar: ");
		columna = scan.nextInt();
		System.out.println("Ingrese el numero nuevo: ");
		numero_nuevo = scan.nextInt();

		if((fila >= 0 && fila < 2) && (columna >= 0 && columna < 3)) {
			matriz[fila][columna] = numero_nuevo;
		}else {
			System.out.println("El numero ingresado debe estar dentro del rango de fila y columna");
		}

		System.out.println("**************************************************");
		System.out.println("Impresion de nueva matriz");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " | "); // Espacio entre los números
			}
			System.out.println(); // Salto de línea después de cada fila
		}
	}
}

