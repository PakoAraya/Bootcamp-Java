package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Producto[] productos = new Producto[7];  // Arreglo para almacenar hasta 7 productos
		int contadorProductos = 0;
		int opcion;

		// Menú principal
		do {
			System.out.println("\n--- MENÚ DE OPCIONES ---");
			System.out.println("1. Agregar producto");
			System.out.println("2. Modificar producto");
			System.out.println("3. Ver lista de productos");
			System.out.println("4. Salir");
			System.out.print("Elija una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine();  // Limpiar el buffer

			switch (opcion) {
			case 1:
				if (contadorProductos < 7) {
					// Agregar un nuevo producto
					System.out.println("Ingrese el nombre del producto:");
					String nombre = scanner.nextLine();
					System.out.println("Ingrese el valor del producto:");
					int valor = scanner.nextInt();
					scanner.nextLine();  // Limpiar el buffer
					System.out.println("Ingrese la descripción del producto:");
					String descripcion = scanner.nextLine();

					productos[contadorProductos] = new Producto(nombre, valor, descripcion);
					contadorProductos++;
					System.out.println("Producto agregado con éxito.");
				} else {
					System.out.println("No se pueden agregar más de 7 productos.");
				}
				break;

			case 2:
				// Modificar un producto existente
				System.out.println("Ingrese el número del producto que desea modificar (1 a " + contadorProductos + "):");
				int indice = scanner.nextInt() - 1;
				scanner.nextLine();  // Limpiar el buffer

				if (indice >= 0 && indice < contadorProductos) {
					System.out.println("Ingrese el nuevo nombre del producto (o presione Enter para no cambiar):");
					String nuevoNombre = scanner.nextLine();
					if (!nuevoNombre.isEmpty()) {
						productos[indice].setNombre(nuevoNombre);
					}

					System.out.println("Ingrese el nuevo valor del producto (o 0 para no cambiar):");
					int nuevoValor = scanner.nextInt();
					scanner.nextLine();  // Limpiar el buffer
					if (nuevoValor != 0) {
						productos[indice].setValor(nuevoValor);
					}

					System.out.println("Ingrese la nueva descripción del producto (o presione Enter para no cambiar):");
					String nuevaDescripcion = scanner.nextLine();
					if (!nuevaDescripcion.isEmpty()) {
						productos[indice].setDescripcion(nuevaDescripcion);
					}

					System.out.println("Producto modificado con éxito.");
				} else {
					System.out.println("Número de producto inválido.");
				}
				break;

			case 3:
				// Ver lista de productos
				System.out.println("\n--- Lista de Productos ---");
				for (int i = 0; i < contadorProductos; i++) {
					System.out.print((i + 1) + ". ");
					productos[i].mostrarProducto();
				}
				break;

			case 4:
				System.out.println("Saliendo del programa...");
				break;

			default:
				System.out.println("Opción no válida. Intente nuevamente.");
			}
		} while (opcion != 4);

		scanner.close();		
	}
}
