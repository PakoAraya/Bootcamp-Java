package session_14;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Club club = new Club();
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("\n--- Menú del Club ---");
			System.out.println("1. Agregar Socio");
			System.out.println("2. Mostrar Socios");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la línea pendiente

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el nombre del socio: ");
				String nombre = scanner.nextLine();

				System.out.print("Ingrese la edad del socio: ");
				int edad = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese el cargo del socio: ");
				String cargo = scanner.nextLine();

				Socio nuevoSocio = new Socio(nombre, edad, cargo);

				try {
					club.agregarSocio(nuevoSocio);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				club.mostrarSocios();
				break;

			case 3:
				salir = true;
				System.out.println("Saliendo del programa...");
				break;

			default:
				System.out.println("Opción no válida. Intente de nuevo.");
				break;
			}
		}

		scanner.close();
	}
}
