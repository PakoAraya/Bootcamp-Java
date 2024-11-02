package com.papeleria.modelo;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	private List<Producto> productos;
	private double total;

	public Venta() {
		productos = new ArrayList<>();
		total = 0;
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
		total += producto.getPrecio();
	}

	public double getTotal() {
		return total;
	}

	public List<Producto> getProductos() {
		return productos;
	}
}