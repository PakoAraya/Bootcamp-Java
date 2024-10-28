package session_02;

import java.util.Scanner;

/*INSTRUCCIONES
Ejercicio 10: Contar Números Positivos y Negativos en un Arreglo (1pts)
• Descripción: Crea un arreglo de 10 números enteros, permite al usuario
	ingresar los valores y luego cuenta cuántos números son positivos y cuántos
	son negativos.
• Instrucciones:
	o Usa if para verificar si los números son positivos o negativos.
*/
public class Ejercicio10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		int contadorPositivos = 0;
		int contadorNegativos = 0;
		
		//Permitirle al usuario que ingrese los numeros
		System.out.println("Ingrese 10 numeros enteros...");
		for (int i=0; i<numeros.length; i++) {
			System.out.println("Numero " + (i+1) + ": ");
			numeros[i] = scan.nextInt();
			
			//Verificar la cantidad de numeros positivos y negativos
			if(numeros[i] >= 0) {
				contadorPositivos++;
			}else if(numeros[i] < 0) {
				contadorNegativos++;
			}
		}
		
		//Mostrar los resultados
		System.out.println("La cantidad de numeros positivos es: " + contadorPositivos);
		System.out.println("La cantidad de numeros negativos es: " + contadorNegativos);
		scan.close();
	}
}
