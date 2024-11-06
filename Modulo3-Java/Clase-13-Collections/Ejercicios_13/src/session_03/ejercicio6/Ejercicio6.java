package session_03.ejercicio6;

import java.util.Iterator;
import java.util.Stack;

/*
 * INSTRUCCIONES
Ejercicio 6: Pila de tareas Simula una lista de tareas donde las tareas más recientes
se apilan y se completan en orden inverso. Usa una pila para almacenar las tareas y
completa las más recientes primero.
Requisitos:
• Apilar 4 tareas.
• Completar las 2 últimas tareas.
• Mostrar las tareas restantes.
 */
public class Ejercicio6 {
	public static void main(String[] args) {
		//Vamos a declarar el stack
		Stack<String> tareas = new Stack<>();

		//Vamos a cargar el stack con tareas
		tareas.push("Barrer el piso");
		tareas.push("Lavar la ropa");
		tareas.push("Lavar la loza");
		tareas.push("Estudiar");

		//Mostrar el listado de tareas
		System.out.println("El listado de tareas es: " + tareas);

		//Vamos completar las primeras 2 tareas
		if (!tareas.isEmpty()) {
			System.out.println("1era tarea completada: " + tareas.pop());
		}

		if (!tareas.isEmpty()) {
			System.out.println("2da tarea completada: " + tareas.pop());
		}
		//Se imprime el resto de tareas que quedan por hacer
		if(!tareas.isEmpty()) {
			for(String tarea : tareas) {
				System.out.println("- " + tarea);
			}
		}else {
			System.out.println("No quedan mas tareas...");
		}
	}
}
