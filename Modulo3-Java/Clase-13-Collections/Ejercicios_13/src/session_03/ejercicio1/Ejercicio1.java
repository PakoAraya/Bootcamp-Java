package session_03.ejercicio1;

import java.util.LinkedList;
import java.util.Queue;

/*
 * INSTRUCCIONES 
Ejercicios para Queue (Colas)
1. Ejercicio 1: Simulación de una cola de supermercado Crea una aplicación
que simule una cola de clientes en un supermercado. Cada cliente es
representado por su nombre. Usa una Queue para gestionar la cola de
clientes. A medida que se atienden, los clientes son eliminados de la cola.										√
Requisitos:
o Agregar 5 clientes a la cola.																																√
o Simular la atención de los 3 primeros clientes.
o Mostrar los clientes restantes en la cola.
 */
public class Ejercicio1 {
	public static void main(String[] args) {
		Queue<String> clientesCola = new LinkedList<String>();

		//Vamos a agregar los clientes a la cola
		clientesCola.offer("Carlos");
		clientesCola.offer("Marcela");
		clientesCola.offer("Pablo");
		clientesCola.offer("Jacky");
		clientesCola.offer("Felipe");

		//Imprimir la cola con los datos.
		System.out.println("Los datos en la cola son: " + clientesCola);

		//Simular la atencion de los primeros 3 clientes.
		for (int i=0; i<3; i++) {
			String clienteAtendido = clientesCola.poll(); 
			System.out.println("Atendiendo a cliente: " + clienteAtendido);
		}
		//Mostrar los clientes restantes de la cola
		System.out.println("\nClientes restantes: " + clientesCola);

	}
}
