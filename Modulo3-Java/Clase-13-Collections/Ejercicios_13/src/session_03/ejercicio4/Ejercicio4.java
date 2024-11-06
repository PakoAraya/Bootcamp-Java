package session_03.ejercicio4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * INSTRUCCIONES
Ejercicio 4: Inventario de productos Crea un inventario de productos usando un
Map, donde las claves son los nombres de los productos y los valores son sus
precios. Luego, permite buscar el precio de un producto específico.
Requisitos:
• Añadir 4 productos con sus precios.																												√
• Permitir buscar el precio de un producto específico.																			√
 */
public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//Vamos a crear el map
		Map<String, Double> inventario = new HashMap<>();

		//Ahora vamos a cargar el Hashmap
		inventario.put("Cafe", 3490.0);
		inventario.put("Leche", 1399.0);
		inventario.put("Crema", 1499.0);
		inventario.put("Azucar", 749.0);

		//Pedir al usuario que ingrese un nombre de producto para comenzar la busqueda
		//Primero mostramos el listado de productos.
		System.out.println("Listado de productos: ");
		inventario.forEach((producto, precio) -> System.out.println("- " + producto));
		System.out.println("Ingrese el producto que desea para ver el precio: ");
		String nombreProducto = scan.nextLine();

		//Obtener el precio del producto
		Double precioProducto = inventario.get(nombreProducto);
		if(precioProducto != null) {
			System.out.println("El precio de: " + nombreProducto + " es: $" + precioProducto);
		}else {
			System.out.println("El producto " + nombreProducto + " no existe en el inventario...");
		}
	}
}
