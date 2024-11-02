package com.papeleria.util;

import com.papeleria.modelo.Producto;
import com.papeleria.modelo.Venta;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDeArchivos {

	public List<Producto> leerProductos(String nombreArchivo) {
		List<Producto> productos = new ArrayList<>();
		try (InputStream archivo = new FileInputStream(nombreArchivo);
				Workbook workbook = new XSSFWorkbook(archivo)) {

			Sheet hoja = workbook.getSheetAt(0);
			for (Row fila : hoja) {
				// Verificar si la fila tiene celdas
				if (fila.getPhysicalNumberOfCells() >= 3) { // Asegurarse de que hay al menos 3 celdas
					String nombre = fila.getCell(0) != null ? fila.getCell(0).getStringCellValue() : "";
					double precio = fila.getCell(1) != null ? fila.getCell(1).getNumericCellValue() : 0.0;
					String codigo = fila.getCell(2) != null ? fila.getCell(2).getStringCellValue() : "";
					productos.add(new Producto(codigo, nombre, precio));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public void escribirProductos(String nombreArchivo, List<Producto> productos) {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet hoja = workbook.createSheet("Productos");
			int rowIndex = 0;

			for (Producto producto : productos) {
				Row fila = hoja.createRow(rowIndex++);
				fila.createCell(0).setCellValue(producto.getNombre());
				fila.createCell(1).setCellValue(producto.getPrecio());
				fila.createCell(2).setCellValue(producto.getCodigo());
			}

			try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
				workbook.write(fileOut);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}