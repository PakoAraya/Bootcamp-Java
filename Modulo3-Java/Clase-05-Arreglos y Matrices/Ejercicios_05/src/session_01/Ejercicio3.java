package session_01;

import java.util.Scanner;

//Ejercicio 3: Promedio de Notas en un Arreglo
//• Descripción: Crea un programa que almacene las notas de 5 estudiantes en
//un arreglo, y luego calcule el promedio de las notas.
//Instrucciones:
//1. Declara un arreglo de 5 notas.
//2. Permite al usuario ingresar las notas.
//3. Calcula el promedio de las notas ingresadas.
//4. Imprime el promedio en consola.

public class Ejercicio3 {
	public static void main(String[] args) {
		//Declaracion del arreglo y de variables de uso
		double[] notas = new double[5];
		Scanner scan = new Scanner(System.in);
		double promedio, suma_notas = 0;

		System.out.println("/******************************************/");
		System.out.println("/******* APP Para Calcular Promedio *******/");
		System.out.println("/******************************************/");

		//Se pasa por ciclo for para ir ingresando nota por nota
		for(int i=0; i < notas.length; i++) {
			System.out.println("Ingrese la nota N" + i + " : ");
			notas[i] = scan.nextDouble();
			suma_notas += notas[i]; 
		}
		promedio = suma_notas / notas.length;
		System.out.println("Suma = "+ suma_notas);
		System.out.println("El promedio de las notas es: " + promedio);
		scan.close();
	}
}
