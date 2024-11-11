package session_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mercado mercado = new Mercado();
		List<Producto> productos = new ArrayList<>();

		System.out.println("Introduzca el nombre de su producto:");
		String nombre = scanner.nextLine();

		System.out.println("Introduzca el ID de su producto:");
		int idProducto = Integer.parseInt(scanner.nextLine());

		System.out.println("¿Cuál es la condición de su producto?");
		String condicion = scanner.nextLine();

		System.out.println("¿Cuál es el precio de su producto?");
		String precio = scanner.nextLine();

		Producto producto = Producto.crearAviso(nombre, idProducto, condicion, precio);
		productos = mercado.publicarAviso(productos, producto);

		mercado.verTodoAviso(productos);
		scanner.close();
	}
}
