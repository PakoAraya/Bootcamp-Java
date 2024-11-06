package session_01.ejercicio1;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* Instrucciones
Ejercicio 1: Investigando Collector
Objetivo: Investigar cómo se utiliza Collector para recolectar elementos filtrados en
una nueva variable.

Instrucciones:
1. Crea una lista de números enteros.																													√
2. Filtra todos los números mayores que 10.                                                   √
3. Utiliza un Collector para almacenar el resultado en un nuevo ArrayList.										√
4. Imprime el contenido del nuevo ArrayList.																									√
PISTA: Collectors.toList()
List<Integer> numeros = List.of(5, 12, 18, 6, 7, 25, 9);

 */

public class Ejercicio1 {
	public static void main(String[] args) {
		List<Integer> numeros = List.of(5, 12, 18, 6, 7, 25, 9);

		System.out.println("Usando Stream");
		//Filrar numeros mayores que 10
		numeros
		.stream()
		.filter(numero -> numero > 10)
		.forEach(System.out::println);

		System.out.println("\nUsando Collectors");
		List<Integer> numerosFiltrados = numeros
				.stream()
				.filter(numero -> numero >10)
				.collect(Collectors.toList());
		//Vamos a imprimir numeros filtrados con collector.
		System.out.println("Numeros mayores de 10 con Collectors: " + numerosFiltrados);
	}
}
