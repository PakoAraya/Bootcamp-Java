package session_01.ejercicio3;

import java.util.List;
import java.util.stream.Collectors;

/*
 * INSTRUCCIONES
Ejercicio 3: Aplicar filtros con compareTo
Objetivo: Aplicar el método compareTo para filtrar elementos de una lista.
Instrucciones:
1. Crea una lista de números enteros.																										√
2. Filtra los números que son mayores que un valor dado utilizando compareTo.						√
3. Imprime el resultado filtrado.																												√
List<Integer> numeros = List.of(2, 10, 25, 4, 18, 30,45,765,-1);
 */
public class Ejercicio3 {
	public static void main(String[] args) {
		List<Integer> numeros = List.of(2, 10, 25, 4, 18, 30, 45, 765, -1);

		//Definir el valor de comparacion
		int valorDado = 20;
		//Filtrar los numeros mayores contra compareTo
		List<Integer> filtrados = numeros
				.stream()
				.filter(numero -> numero.compareTo(valorDado)>0)
				.collect(Collectors.toList());

		//Imprimir el resultado filtrado
		System.out.println("Numeros mayores que " + valorDado + ": " + filtrados);
	}
}

