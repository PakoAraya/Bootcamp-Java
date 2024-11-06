package session_03.ejercicio5;

import java.util.Stack;

/*
 * INSTRUCCIONES
Ejercicio 5: Deshacer operaciones Simula un sistema de edición de texto donde los
usuarios pueden agregar texto a un Stack para representar acciones recientes (ej:
“escribió hola”, “borro una línea”,“agrego colores” …). 																			√
Luego, implementa una función de "deshacer" que elimina las últimas operaciones.
Requisitos:
• Apilar 3 operaciones.
• Deshacer las 2 últimas operaciones.
• Mostrar la operación restante.
 */
public class Ejercicio5 {
	public static void main(String[] args) {
		//Vamos a declarar el stack
		Stack<String> operaciones = new Stack<String>();

		//Agregaremos elementos al stack
		operaciones.push("Escribio 'Hola'");
		operaciones.push("Borro una linea");
		operaciones.push("Agrego Colores");

		//Vamos a quitar las 2 ultimas operaciones y mostrar la que queda
		System.out.println("Operaciones del Stack");
		System.out.println(operaciones);

		if(!operaciones.isEmpty()) {
			System.out.println("\nSe deshizo operacion: " + operaciones.pop());
			System.out.println("Stack restante " + operaciones);
		}

		if (!operaciones.isEmpty()) {
			System.out.println("Se deshizo operacion: " + operaciones.pop());
			System.out.println("Stack restante " + operaciones);
		}

		if (!operaciones.isEmpty()) {
			System.out.println("Operacion restante: " + operaciones.peek());
			System.out.println("Stack restante " + operaciones);
		}else {
			System.out.println("No quedan operaciones");
		}

	}
}
