package session_02;

import java.util.Scanner;

/*INSTRUCCIONES
Ejercicio 5: Búsqueda en un Arreglo (1pt)
• Descripción: Permite al usuario ingresar 5 números en un arreglo. Luego, pide
	al usuario que ingrese un número adicional y verifica si ese número está
	presente en el arreglo.
• Instrucciones:
	o Usa un if para verificar si el número está en el arreglo.
*/
public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[5];
		
		//Pedir al usuario que ingrese 5 numeros
		System.out.println("App para ingresar numeros");
		for(int i=0; i<numeros.length; i++) {
			System.out.println("Ingresa un numero para la posicion " + (i + 1) + ": ");
			numeros[i] = scan.nextInt();
		}
		
		//Ahora pedimos un numero al usuario para que lo busquemos dentro del arreglo
		System.out.println("\nIngrese numero para ser buscado: ");
		int numeroBuscar = scan.nextInt();
		
		//Comenzamos con la busqueda
		boolean encontrado = false;
		for(int num : numeros) {
			if(num == numeroBuscar) {
				encontrado = true;
				break;
			}
		}
		
		if(encontrado) {
			System.out.println("El numero " + numeroBuscar + " esta en el arreglo...");
		}else {
			System.out.println("El numero " + numeroBuscar + " no esta en el arreglo...");
		}
		scan.close();
	}
}
