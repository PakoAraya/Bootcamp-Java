package session_18;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
	private List<Producto> productos = new ArrayList<>();

	public List<Producto> publicarAviso(List<Producto> productos, Producto producto) {
		productos.add(producto);
		System.out.println("Su producto ha sido subido al mercado online.");
		return productos;
	}

	public void verTodoAviso(List<Producto> productos) {
		System.out.println("Los productos disponibles en el mercado ahora son:");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
}
