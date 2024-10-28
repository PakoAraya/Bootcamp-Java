package session_02;

import java.util.Scanner;

//• Descripción: Crea un arreglo de 5 números enteros, permite al usuario
//ingresar los valores y luego imprime cuántos de esos números son pares.
//• Instrucciones:
//o Crea un arreglo de 5 enteros.
//o Ingresar los valores por consola.
//o Usar un if para verificar si el número es par.
//o Imprimir cuántos números son pares.

public class Ejercicio1 {
	public static void main(String[] args) {
		int[] numeros = new int[5];
		int par=0, impar=0;
		Scanner scan = new Scanner(System.in);

		System.out.println("Par | Impar App");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Ingrese un numero para " + (i+1) + ": ");
			numeros[i] = scan.nextInt();

			if(numeros[i]%2 == 0 ) {
				par++;
			}else {
				impar++;
			}
		}

		System.out.println("*************************************************");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Numero en posicion " + (i+1) + ": " + numeros[i]);
		}
		System.out.println("La cantidad de numeros pares es: " + par);
		System.out.println("La cantidad de numeros impares es: " + impar);		
	}
}
