package com.papeleria.servicio;

import com.papeleria.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {
	private List<Producto> productos;

	public ProductoService() {
		productos = new ArrayList<>();
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	public List<Producto> getProductos() {
		return productos;
	}
}