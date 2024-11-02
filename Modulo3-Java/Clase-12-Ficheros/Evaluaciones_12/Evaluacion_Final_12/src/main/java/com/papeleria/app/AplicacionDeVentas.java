package com.papeleria.app;

import com.papeleria.modelo.Producto;
import com.papeleria.modelo.Venta;
import com.papeleria.servicio.ProductoService;
import com.papeleria.servicio.VentaService;
import com.papeleria.util.GestorDeArchivos;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AplicacionDeVentas {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductoService productoService = new ProductoService();
		VentaService ventaService = new VentaService();
		GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();

		// Leer productos desde un archivo Excel
		List<Producto> productos = gestorDeArchivos.leerProductos("src/main/resources/productos.xlsx");
		for (Producto producto : productos) {
			productoService.agregarProducto(producto);
		}

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Ver Productos");
			System.out.println("2. Agregar Producto a la Venta");
			System.out.println("3. Agregar Nuevo Producto");
			System.out.println("4. Generar Comprobante");
			System.out.println("5. Salir");

			System.out.print("Selecciona una opción: ");
			int opcion = scanner.nextInt();
			System.out.println("\nHas escogido Opcion: " + opcion);

			switch (opcion) {
			case 1:
				// Mostrar los productos disponibles
				List<Producto> productosDisponibles = productoService.getProductos();
				if (productosDisponibles.isEmpty()) {
					System.out.println("No hay productos disponibles.");
				} else {
					System.out.println("\nProductos disponibles:");
					for (Producto producto : productosDisponibles) {
						System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Código: " + producto.getCodigo());
					}
				}
				break;

			case 2:
				// Agregar producto a la venta
				if (!productoService.getProductos().isEmpty()) {
					System.out.print("Selecciona el índice del producto a agregar (0 para el primero, 1 para el segundo, etc.): ");
					int indice = scanner.nextInt();
					if (indice >= 0 && indice < productoService.getProductos().size()) {
						Producto productoSeleccionado = productoService.getProductos().get(indice);
						System.out.println("¿Desea agregar " + productoSeleccionado.getNombre() + " por " + productoSeleccionado.getPrecio() + " a su carrito de compras?");
						System.out.print("Si para agregar o No para cancelar: ");
						String respuesta = scanner.next();
						if (respuesta.equalsIgnoreCase("si")) {
							ventaService.agregarProducto(productoSeleccionado);
							System.out.println("Producto agregado a la venta: " + productoSeleccionado.getNombre());
						} else {
							System.out.println("Producto no agregado.");
						}
					} else {
						System.out.println("Índice no válido.");
					}
				} else {
					System.out.println("No hay productos disponibles para agregar.");
				}
				break;

			case 3:
				// Agregar nuevo producto
				System.out.print("Ingrese el nombre del producto: ");
				String nombre = scanner.next();
				double precio = 0.0;
				while (true) {
					try {
						System.out.print("Ingrese el precio del producto: ");
						precio = scanner.nextDouble();
						break; // Si la entrada es correcta, salir del bucle
					} catch (InputMismatchException e) {
						System.out.println("Por favor, ingrese un número válido para el precio.");
						scanner.next(); // Limpiar el buffer
					}
				}
				System.out.print("Ingrese el código del producto: ");
				String codigo = scanner.next();

				Producto nuevoProducto = new Producto(codigo, nombre, precio);
				productoService.agregarProducto(nuevoProducto);

				// Escribir todos los productos en el archivo
				gestorDeArchivos.escribirProductos("src/main/resources/productos.xlsx", productoService.getProductos());

				System.out.println("¿Desea agregar " + nuevoProducto.getNombre() + " por " + nuevoProducto.getPrecio() + " a su lista de productos?");
				System.out.print("Si para agregar o No para cancelar: ");
				String respuestaNuevo = scanner.next();
				if (respuestaNuevo.equalsIgnoreCase("si")) {
					System.out.println("Producto agregado.");
				} else {
					System.out.println("Producto no agregado.");
				}
				break;

			case 4:
				// Generar comprobante
				if (ventaService.getTotal() > 0) {
					String rutaComprobante = "src/main/resources/comprobante.txt"; // Cambiar a la ruta deseada
					ventaService.generarComprobante(rutaComprobante);
					System.out.println("Comprobante generado en: " + rutaComprobante);
				} else {
					System.out.println("No se ha agregado ningún producto a la venta.");
				}
				break;

			case 5:
				// Salir del programa
				System.out.println("Saliendo...");
				scanner.close();
				return;

			default:
				System.out.println("Opción no válida, por favor selecciona otra.");
			}
		}
	}
}