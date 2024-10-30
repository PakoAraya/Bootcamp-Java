package dia3.ejercicio1;

/**
 * @author  : Francisco Javier Araya
 * @version : 0.0.1
 * @since   : 11-10-2024
 */

public class Ejercicio1 {
	public static void main(String[] args) {
		// Crear instancias de Electrodomestico y Television
		Electrodomestico lavadora = new Electrodomestico("LG", "T900", 500);
		Television tv = new Television("Samsung", "QLED", 150, 55, "LED", "4k", true);
		Electrodomestico nevera = new Electrodomestico("Whirlpool", "Nexus", 120); // Consumo menor que el televisor
		Electrodomestico aspiradora = new Electrodomestico("Dyson", "V11", 90); // Consumo menor que el televisor
		Electrodomestico microondas = new Electrodomestico("Panasonic", "NN-SN686", 120); // Consumo menor que el televisor

		// Imprimir los detalles de todos los electrodomésticos
		System.out.println(lavadora);
		System.out.println(tv);
		System.out.println(nevera);
		System.out.println(aspiradora);
		System.out.println(microondas);

		// Comparar el consumo de los electrodomésticos utilizando el método genérico
		Electrodomestico menorConsumo = Utilidades.elementoDeMenorConsumo(lavadora, tv);
		System.out.println("El electrodoméstico de menor consumo entre lavadora y televisor es: " + menorConsumo);

		// Comparar el televisor con los otros electrodomésticos
		Electrodomestico menorConsumoTV = Utilidades.elementoDeMenorConsumo(tv, nevera);
		System.out.println("El electrodoméstico de menor consumo entre televisor y nevera es: " + menorConsumoTV);

		Electrodomestico menorConsumoAspiradora = Utilidades.elementoDeMenorConsumo(tv, aspiradora);
		System.out.println("El electrodoméstico de menor consumo entre televisor y aspiradora es: " + menorConsumoAspiradora);

		Electrodomestico menorConsumoMicroondas = Utilidades.elementoDeMenorConsumo(tv, microondas);
		System.out.println("El electrodoméstico de menor consumo entre televisor y microondas es: " + menorConsumoMicroondas);
	}
}
