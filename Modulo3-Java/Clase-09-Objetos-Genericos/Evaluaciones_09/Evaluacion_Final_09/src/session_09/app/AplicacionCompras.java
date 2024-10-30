package session_09.app;

import session_09.modelos.Zapatos;
import session_09.modelos.Polera;
import session_09.colecciones.Bolsa;
import java.util.Scanner;

public class AplicacionCompras {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la capacidad de la bolsa: ");
		int capacidad = scanner.nextInt();

		System.out.print("¿Desea una bolsa para Zapatos o Poleras? (Ingrese 'zapatos' o 'poleras'): ");
		String eleccion = scanner.next();

		if ("zapatos".equalsIgnoreCase(eleccion)) {
			Bolsa<Zapatos> bolsaZapatos = new Bolsa<>(capacidad);
			for (int i = 0; i < capacidad; i++) {
				System.out.print("Ingrese la marca de los zapatos #" + (i + 1) + ": ");
				String marca = scanner.next();
				bolsaZapatos.agregarItem(new Zapatos(marca));
			}
			System.out.println("Artículos en la bolsa de zapatos:");
			bolsaZapatos.mostrarItems();

		} else if ("poleras".equalsIgnoreCase(eleccion)) {
			Bolsa<Polera> bolsaPoleras = new Bolsa<>(capacidad);
			for (int i = 0; i < capacidad; i++) {
				System.out.print("Ingrese el color de la polera #" + (i + 1) + ": ");
				String color = scanner.next();
				bolsaPoleras.agregarItem(new Polera(color));
			}
			System.out.println("Artículos en la bolsa de poleras:");
			bolsaPoleras.mostrarItems();
		} else {
			System.out.println("Elección inválida. Reinicie y elija 'zapatos' o 'poleras'.");
		}

		scanner.close();
	}
}