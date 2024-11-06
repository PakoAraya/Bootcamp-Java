package session_03;

import java.util.Stack;

//Hoy veremos listas enlazadas, colas, pilas, mapas entre otras cosas
//PILAS

/*push(): Apila (agrega) un plato a la pila.
pop(): Retira (quita) el plato en la parte superior de la pila.
peek(): Muestra el plato en la parte superior sin retirarlo.
empty(): Verifica si la pila está vacía.*/

public class Ejemplo1 {
	public static void main(String[] args) {
		//Declaracion de una pila de tipo String
		Stack<String> pilaDeDatos = new Stack<>();
		//Agregando elementos a la pila
		pilaDeDatos.push("Plato 1");
		pilaDeDatos.push("Plato 2");
		pilaDeDatos.push("Plato 3");

		//Vamos a ver a Peek
		//Recordemos que solo visualiza, no lo quita de la pila
		System.out.println("Accedemos a Peek: " + pilaDeDatos.peek());
		System.out.println("Pila de Datos: " + pilaDeDatos);

		//Vamos a ver a Pop
		//Recordemos que aqui elimina el ultimo elemento que ingreso a la pila
		System.out.println("\nAplicando plop");
		System.out.println("Accedemos a Pop: " + pilaDeDatos.pop());
		System.out.println("Pila de Datos: " + pilaDeDatos);

		//Vamos a ver a empty
		//Empty nos indica que la pila esta vacia
		System.out.println("Aplicamos Pop: " + pilaDeDatos.pop());
		System.out.println("Aplicamos Pop: " + pilaDeDatos.pop());
		System.out.println("Aplicamos Empty: " + pilaDeDatos.empty());

		System.out.println("Pila de Datos: " + pilaDeDatos);
	}
}
