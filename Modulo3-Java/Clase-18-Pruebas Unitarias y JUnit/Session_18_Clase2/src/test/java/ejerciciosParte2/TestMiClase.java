package ejerciciosParte2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("Pruebas para MiClase")
public class TestMiClase {

	private MiClase miClase;

	@BeforeEach
	void setUp() {
		miClase = new MiClase();
	}

	// Ejercicio: Método obtenerIniciales
	@Test
	@DisplayName("Prueba de método obtenerIniciales")
	void testObtenerIniciales() {
		assertEquals("A.B.C.", miClase.obtenerIniciales("Alice Bob Carol"), "Las iniciales de 'Alice Bob Carol' deberían ser 'A.B.C.'");
		assertEquals("J.D.", miClase.obtenerIniciales("john doe"), "Las iniciales de 'John Doe' deberían ser 'J.D.'");
		assertEquals("M.", miClase.obtenerIniciales("Maria"), "Las iniciales de 'Maria' deberían ser 'M.'");
	}

	// Ejercicio: Método obtenerMayor
	@Test
	@DisplayName("Prueba de método obtenerMayor")
	void testObtenerMayor() {
		assertEquals(9, miClase.obtenerMayor(new int[] {3, 5, 9, 2}), "El mayor valor del array debería ser 9");
		assertEquals(-1, miClase.obtenerMayor(new int[] {-5, -3, -1, -4}), "El mayor valor del array debería ser -1");
		assertEquals(7, miClase.obtenerMayor(new int[] {7}), "El mayor valor de un array con un solo elemento debería ser 7");
	}

	// Ejercicio: Método contarPares
	@Test
	@DisplayName("Prueba de método contarPares")
	void testContarPares() {
		assertEquals(3, miClase.contarPares(new int[] {2, 3, 4, 6, 7}), "Debería haber 3 números pares");
		assertEquals(0, miClase.contarPares(new int[] {1, 3, 5, 7}), "Debería haber 0 números pares");
		assertEquals(1, miClase.contarPares(new int[] {2}), "Debería haber 1 número par en un array con un solo elemento");
	}

	// Ejercicio: Método esNumeroTelefonoValido
	@Test
	@DisplayName("Prueba de método esNumeroTelefonoValido")
	void testEsNumeroTelefonoValido() {
		assertTrue(miClase.esNumeroTelefonoValido("1234567890"), "El número de teléfono debería ser válido");
		assertFalse(miClase.esNumeroTelefonoValido("12345"), "El número de teléfono no debería ser válido");
		assertFalse(miClase.esNumeroTelefonoValido("12345678901"), "El número de teléfono no debería ser válido");
	}

	// Ejercicio: Método esCadenaVacia
	@Test
	@DisplayName("Prueba de método esCadenaVacia")
	void testEsCadenaVacia() {
		assertTrue(miClase.esCadenaVacia(""), "La cadena vacía debería retornar true");
		assertTrue(miClase.esCadenaVacia(null), "Una cadena null debería retornar true");
		assertFalse(miClase.esCadenaVacia("texto"), "Una cadena no vacía debería retornar false");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Prueba completada.");
	}

}