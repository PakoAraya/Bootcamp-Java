package session_18test;

import org.junit.jupiter.api.Test;

import session_18.Mercado;
import session_18.Producto;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class MercadoTest {
	@Test
	public void testPublicarAviso() {
		Mercado mercado = new Mercado();
		List<Producto> productos = new ArrayList<>();
		Producto producto = Producto.crearAviso("Computadora X", 111, "Nuevo", "$500.000");

		List<Producto> resultado = mercado.publicarAviso(productos, producto);
		assertNotNull(resultado);
		assertEquals(1, resultado.size());
		assertEquals(producto, resultado.get(0));
	}
}
