package principal;

import modelo.Cocina;
import modelo.Refrigerador;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Crear instancias de productos
		Cocina cocina = new Cocina(300.0, 10, 4);
		Refrigerador refrigerador = new Refrigerador(500.0, 5, "A", 2);

		System.out.println("Bienvenido a la tienda de electrodomésticos.");
		System.out.println("Elige una opción para comprar:");
		System.out.println("1. Comprar Cocina");
		System.out.println("2. Comprar Refrigerador");
		System.out.println("3. Cancelar");

		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("¿Desea que la cocina incluya gas? (true/false): ");
			boolean incluyeGas = scanner.nextBoolean();
			if (cocina.incluyeGas(incluyeGas)) {
				System.out.println("La cocina incluye gas.");
			} else {
				System.out.println("La cocina no incluye gas.");
			}

			System.out.println("¿Confirma la compra de la cocina? (true/false): ");
			boolean confirmaCocina = scanner.nextBoolean();
			if (confirmaCocina) {
				cocina.reducirCantidadDisponible();
				System.out.println("Compra de cocina realizada con éxito. Gracias por su compra.");
			} else {
				System.out.println("Compra de cocina cancelada.");
			}
			break;

		case 2:
			System.out.println("¿Confirma la compra del refrigerador? (true/false): ");
			boolean confirmaRefrigerador = scanner.nextBoolean();
			if (confirmaRefrigerador) {
				refrigerador.reducirCantidadDisponible();
				System.out.println("Compra de refrigerador realizada con éxito. Gracias por su compra.");
			} else {
				System.out.println("Compra de refrigerador cancelada.");
			}
			break;

		case 3:
			System.out.println("Compra cancelada. ¡Gracias por visitarnos!");
			break;

		default:
			System.out.println("Opción no válida.");
		}

		scanner.close();
	}
}