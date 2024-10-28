package session_02;

import java.util.Scanner;

//Ejercicio 2: Suma de Elementos en un Arreglo (1pt)
//• Descripción: Crea un arreglo de 10 números enteros, permite al usuario
//ingresar los valores y luego imprime la suma de todos los elementos.
//• Instrucciones:
//o Crea un arreglo de 10 enteros.
//o Sumar todos los valores e imprimir el resultado.

public class Ejercicio2 {
	public static void main(String[] args) {
		int suma=0, numero=0;
		int[] numeros = new int[10];
		Scanner scan = new Scanner(System.in);

		System.out.println("Arreglo para sumar numeros");
		for(int i=0; i<numeros.length; i++) {
			//Validando que el ingreso de numeros sea positivos
			do {
				System.out.println("Ingrese un numero para la posicion " + (i+1) + ": ");
				numero = scan.nextInt();
				if(numero < 0) {
					System.out.println("Por favor, ingrese solo numeros positivos");
				}
			} while (numero < 0);
			numeros[i] = numero;
			suma += numeros[i];
		}

		//Imprimiendo el arreglo
		for (int i=0; i<numeros.length; i++) {
			System.out.println("El numero de la posicion " + (i + 1) +": " + numeros[i]);
		}

		System.out.println("El resultado de la suma de numeros es: " + suma);
	}
}

