package session_18test;

import org.junit.jupiter.api.Test;

import session_18.Producto;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
	@Test
	public void testCrearAviso() {
		Producto producto = Producto.crearAviso("Computadora X", 111, "Nuevo", "$500.000");
		assertNotNull(producto);
		assertEquals("Computadora X", producto.getNombre());
		assertEquals(111, producto.getIdProducto());
		assertEquals("Nuevo", producto.getCondicion());
		assertEquals("$500.000", producto.getPrecio());
	}
}
