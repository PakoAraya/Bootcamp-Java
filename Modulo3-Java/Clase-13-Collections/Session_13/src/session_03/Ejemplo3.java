package session_03;

import java.util.LinkedList;
import java.util.Queue;

//En este ejemplo veremos cola
//Primero en entrar, primero en salir

public class Ejemplo3 {
	public static void main(String[] args) {
		//Ejemplo de declaracion de colas con listas enlazadas
		Queue<String> filaBanco = new LinkedList<String>();

		//Ahora vamos a llenar la cola (encolar) Se puede usar 2 metodos (add | offer)
		//add  agrega excepcion
		//Offer agrega false
		filaBanco.offer("Persona 1");
		filaBanco.offer("Persona 2");
		filaBanco.offer("Persona 3");
		//Aqui vamos a ver como se imprimen
		System.out.println("Fila Completa: " + filaBanco);

		//Metodos a tener a consideracion
		//peek() Devuelve el primer dato sin eliminar -> null si no es encontrado
		//element() devuelve el primer dato sin eliminar -> Exception si no es encontrado
		System.out.println("\nPrimera persona de la lista: " + filaBanco.peek());

		//Para quitar el primer elementos de la cola (pool | remove)
		//Pool => Si no encuentra nada lanza un null
		//Remove => Si no encuentra nada lanza una excepcion
		System.out.println("Atendiendo a: " + filaBanco.poll());
		System.out.println("Atendiendo a: " + filaBanco);

		//Si quiero ver que persona viene ahora, podemos usar peek
		System.out.println("Siguiente persona: " + filaBanco.peek());
		System.out.println("Atendiendo a: " + filaBanco.poll());
		System.out.println("Atendiendo a: " + filaBanco);
		System.out.println("Atendiendo a: " + filaBanco.poll());
		System.out.println("Atendiendo a: " + filaBanco);
	}
}
