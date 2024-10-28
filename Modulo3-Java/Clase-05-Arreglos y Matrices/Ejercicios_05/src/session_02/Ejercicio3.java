package session_02;

import java.util.Scanner;

//Ejercicio 3: Arreglo de Cadenas y Comparación (1pt) [3 Posiciones]
//• Descripción: Crea un arreglo de 3 cadenas de texto (nombres), permite al
//usuario ingresar los nombres y verifica si el primer nombre ingresado es igual
//al último.
//• Instrucciones:
//o Usar el método equals para comparar cadenas.(investigar)

public class Ejercicio3 {
	public static void main(String[] args) {
		//Declaracion del arreglo para 3 nombres
		String[] nombres = new String[3];
		Scanner scan = new Scanner(System.in);

		//Ingresar por consola los nombres
		System.out.println("Comparador de nombres");
		for(int i=0; i<nombres.length; i++) {
			System.out.println("Ingrese un nombre en la posicion " + i + ": ");
			nombres[i] = scan.nextLine();
		}
		//Hacer la comparacion de los nombres
		if(nombres[0].equals(nombres[2])) {
			System.out.println("El primer nombre es igual al ultimo: " + nombres[0]);
		}else {
			System.out.println("El primer nombre "+ nombres[0] + " NO es igual al ultimo " + nombres[2]);
		}
	}
}
