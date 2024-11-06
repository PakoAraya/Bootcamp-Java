package session_02.ejercicio2;
/*
Ejercicio 2: Buscar un Elemento en la Lista
Descripción: Crea un programa que permita al usuario ingresar varios nombres en un
ArrayList. Luego, permite al usuario buscar si un nombre específico está presente en
la lista.
TIP: usar contains
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		//Creamos un arraylist para guardar los nombnes
		ArrayList<String> nombresList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String nombre;
		String preguntaContinuar;
		String nombreBuscar;

		//Ciclo para ingresar nombres
		System.out.println("******* APP para ingresar nombres *******");
		do{
			System.out.println("Ingrese el nombre del estudiante: ");
			nombre = scan.nextLine().toLowerCase();
			nombresList.add(nombre);

			//Preguntar al usuario si quiere seguir
			System.out.println("Desea ingresar otro nombre??? (si/no): ");
			preguntaContinuar = scan.nextLine().toLowerCase();
		}while (preguntaContinuar.equalsIgnoreCase("si"));

		//Buscar el nombre dentro del arraylist
		System.out.println("\n Ingrese el nombre que desea bucar: ");
		nombreBuscar = scan.nextLine().toLowerCase();
		//Aqui debenmos aplicar el contains
		if(nombresList.contains(nombreBuscar)){
			System.out.println(nombreBuscar + " esta en la Arraylist");
		}else {
			System.out.println(nombreBuscar + " no esta en la Arraylist");
		}
	}
}
