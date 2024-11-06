package session_02.ejercicio1;

/*
Ejercicio 1: Agregar y Mostrar Nombres de Estudiantes
Descripción: Crea un programa que permita al usuario agregar nombres de
estudiantes a un ArrayList hasta que el usuario decida detenerse. Luego, muestra la
lista completa de nombres ingresados.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		//Crearemos un arraylist para almacenar los nombres
		ArrayList<String> estudiantesList = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		String nombre;
		String preguntaContinuar;


		System.out.println("****** APP PARA REGISTRAR ESTUDIANTES ******");
		//Hay que trabajar con ciclos (While | Do-While)
		do {
			System.out.println("Ingresa el nombre del estudiante: ");
			nombre = teclado.nextLine();
			estudiantesList.add(nombre); //De esta manera agregamos estudiantes al arraylist

			//Preguntar si queremos agregar mas estudiantes
			System.out.println("Deseas agregar otro estudiante??? (si/no): ");
			preguntaContinuar = teclado.nextLine();
		}while (preguntaContinuar.equalsIgnoreCase("si"));

		//Mostrar el listado de estudiantes
		System.out.println("\n Lista de estudiantes ingresados: ");
		for(String estudiante:estudiantesList){
			System.out.println(estudiante);
		}
	}
}
