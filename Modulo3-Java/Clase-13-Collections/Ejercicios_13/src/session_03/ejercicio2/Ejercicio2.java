package session_03.ejercicio2;

import java.lang.invoke.StringConcatFactory;
import java.util.LinkedList;
import java.util.Queue;

/*
 * INSTRUCCIONES
Ejercicio 2: Simulación de una fila de pedidos de comida Imagina que tienes una
cola de pedidos en un restaurante de comida rápida. Crea un sistema donde los
pedidos se agregan en una cola y se procesan uno por uno en el orden en que
llegaron.																																											√
Requisitos:
• Agregar 4 pedidos.																																					√
• Procesar los primeros 2 pedidos.																														√
• Mostrar los pedidos restantes.
 */
public class Ejercicio2 {
	public static void main(String[] args) {
		//Vamos a crear fila
		Queue<String> pedidos = new LinkedList<>();

		//Vamos a cargar la fila con datos
		pedidos.offer("Costillar Cantones");
		pedidos.offer("Parrillada China");
		pedidos.offer("Carne Mongoliana");
		pedidos.offer("Pato Pekin");

		//Vamos a procesar los 2 primeros pedidos
		for (int i=0; i<2; i++) {
			String pedidoAtendido = pedidos.poll();
			System.out.println("El pedido atendido es: " + pedidoAtendido);
		}
		//Imprimiendo el resto de los pedidos
		System.out.println("\nLos pedidos restantes son: " + pedidos);
	}
}
