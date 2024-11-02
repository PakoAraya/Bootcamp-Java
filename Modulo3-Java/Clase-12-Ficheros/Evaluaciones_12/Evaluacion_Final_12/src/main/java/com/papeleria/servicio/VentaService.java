package com.papeleria.servicio;

import com.papeleria.modelo.Producto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentaService {
	private List<Producto> productosVendidos;
	private double total;

	public VentaService() {
		this.productosVendidos = new ArrayList<>();
		this.total = 0.0;
	}

	public void agregarProducto(Producto producto) {
		productosVendidos.add(producto);
		total += producto.getPrecio();
	}

	public double getTotal() {
		return total;
	}

	public List<Producto> getProductosVendidos() {
		return productosVendidos;
	}

	public void generarComprobante(String rutaArchivo) {
		StringBuilder comprobante = new StringBuilder();
		comprobante.append("Comprobante de Venta\n");
		comprobante.append("--------------------\n");
		comprobante.append("Total cancelado: ").append(total).append("\n");
		comprobante.append("El detalle de su compra es:\n");

		for (Producto producto : productosVendidos) {
			comprobante.append("Producto [Nombre: ")
			.append(producto.getNombre())
			.append(", Precio: ")
			.append(producto.getPrecio())
			.append(", Codigo: ")
			.append(producto.getCodigo())
			.append("]\n");
		}
		comprobante.append("Gracias por preferirnos...\n");

		// Guardar en archivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
			writer.write(comprobante.toString());
		} catch (IOException e) {
			System.err.println("Error al generar comprobante: " + e.getMessage());
		}

		// Mostrar en consola
		System.out.println(comprobante.toString());
	}
}