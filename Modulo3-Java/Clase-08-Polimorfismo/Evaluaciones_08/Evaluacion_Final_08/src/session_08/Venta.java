package session_08;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	private Vendedor vendedor;
	private List<Producto> carrito;
	private double total;

	public Venta(Vendedor vendedor) {
		this.vendedor = vendedor;
		this.carrito = new ArrayList<>();
		this.total = 0.0;
	}

	public void agregarProducto(Producto producto) {
		if (carrito.size() < 10) {
			carrito.add(producto);
			total += producto.getPrecio();
			System.out.println("Producto agregado: " + producto.getNombre());
		} else {
			System.out.println("Carrito lleno. No se pueden agregar más productos.");
		}
	}

	public void listarCarrito() {
		System.out.println("Productos en el carrito:");
		for (Producto producto : carrito) {
			producto.mostrarDetalles();
		}
	}

	public void pagar() {
		System.out.println("Total a pagar: $" + total);
		System.out.println("Vendedor: " + vendedor.getNombre() + ", RUT: " + vendedor.getRut());
		carrito.clear();
		total = 0.0;
		System.out.println("Pago realizado con éxito.");
	}
}