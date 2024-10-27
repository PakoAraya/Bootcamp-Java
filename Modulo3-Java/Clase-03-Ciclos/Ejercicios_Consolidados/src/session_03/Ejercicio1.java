package session_03;

//Ejercicio 1: Imprimir los primeros N números pares
//• Instrucción: Escribe un programa que solicite al usuario un número entero
//positivo N e imprima los primeros N números pares.
//• Entrada: Un número entero positivo.
//• Salida: Los primeros N números pares.
//• TIP: for, entrada por consola.

import java.util.Scanner;

public class Ejercicio1 {
public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	int numero;
	
	//Solicitar al usuario que ingrese numero positivo
	System.out.println("Ingrese un numero positivo: ");
	numero = scan.nextInt();
	
	//Validar que numero sea positivo.
	if(numero > 0) {
		System.out.println("El numero es positivo y los " + numero + " numeros pares son: ");
		//Imprimir los numeros pares del numero ingresado
		//Contador para los numeros pares encontrados.
		int contador = 0;
		for(int i=2; i <= numero; i++) {
			//Aqui se comprueba que numero es par
			if(i % 2 == 0) {
				System.out.println(i);
				contador++;
			}				
			//Forma alternativa
			//System.out.println(i*2);
		}
		System.out.println("La cantidad de numeros pares es: " + contador);
	}else {
		System.out.println("Debe ingresar un numero positivo");
	}		
}
}