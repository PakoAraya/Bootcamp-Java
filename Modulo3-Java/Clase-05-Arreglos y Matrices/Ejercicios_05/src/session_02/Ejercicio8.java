package session_02;

import java.util.Scanner;

/* INSTRUCCIONES
Ejercicio 8: Búsqueda del Valor Mínimo en un Arreglo(1pt)
• Descripción: Crea un arreglo de 8 números enteros, permite al usuario
	ingresar los valores y luego encuentra el valor mínimo.
• Instrucciones:
	o Usa un if para verificar y almacenar el número más pequeño.
*/
public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[8];
		
		//Ingreso de valores por parte del usuario
		System.out.println("Ingrese 8 numeros enteros");
		for (int i=0; i<numeros.length; i++) {
			System.out.println("Numero: " + (i+1) + ": ");
			numeros[i] = scan.nextInt();
		}
		
		//Encontrar el valor minimo
		int valorMinimo = numeros[0];
		for (int i=0; i<numeros.length; i++) {
			if(numeros[i] < valorMinimo) {
				valorMinimo = numeros[i];
			}
		}
		
		//mostrar el valor minimo
		System.out.println("El valor minimo del arreglo es: " + valorMinimo);
		scan.close();
	}
}
