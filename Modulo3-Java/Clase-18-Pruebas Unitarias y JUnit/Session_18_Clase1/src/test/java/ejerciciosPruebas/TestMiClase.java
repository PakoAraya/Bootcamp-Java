package ejerciciosPruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test para MiClase")
public class TestMiClase {
	//Instanciar la clase MiClase (Crear un objeto para probar los metodos)
	private final MiClase miClase =  new MiClase();

	@Test
	void testEsPar(){
		//salida final esperada, funcion a ejecutar, descripcion 
		assertTrue(miClase.esPar(4));
		assertTrue(miClase.esPar(0));
		assertFalse(miClase.esPar(7), "Prueba Exitosa, reconoce cuando no es par");
		//assertTrue(miClase.esPar(7),"El error esta entre el computador y la silla");
	}

	@Test
	void testMultiplicar() {
		//assertEquals() salida final esperada, funcion a ejecutar, descripcion
		assertEquals(20, miClase.multiplicar(4, 5), "El resultado esperado es 20");
		assertEquals(0, miClase.multiplicar(0, 5), "El resultado esperado es 0");
		assertEquals(-20, miClase.multiplicar(4, -5), "El resultado esperado es -20");
		//assertEquals(20, miClase.multiplicar(4, 4), "El resultado es incorrecto, me da 16 en vez de 20");
	}

	//Metodo para obtener saludo
	@Test
	void testObtenerSaludo() {
		assertEquals("Hola, Esilda", miClase.obtenerSaludo("Esilda"), "Debe entregar Hola, Esilda");
		assertEquals("Hola, Cata", miClase.obtenerSaludo("Cata"), "Debe entregar Hola, cata");
		assertEquals("Hola, null", miClase.obtenerSaludo(null), "Debe entregar Hola, null"); // probando con null
	}

	//Vamos a probar con metodo especial para null
	@Test
	void testObtenerValorNulo() {
		assertNull(miClase.obtenerValorNulo());
	}

	//Test para crear objeto de tipo Persona
	@Test
	void testCrearPersona() {
		Persona persona = new Persona("Ana", 35);
		assertNotNull(persona); //Para comprobar que objeto se ha creado
		assertEquals("Ana", persona.getNombre()); //Debiera traer el nombre de Ana
		assertEquals(35, persona.getEdad()); //Debiera traer la edad de 35
	}

	//Test para calcular un numero al cuadrado
	@Test
	void testCalcularCuadrado() {
		assertEquals(9, miClase.calcularCuadrado(3), "Debe entregar un 9 como resultado");
		assertEquals(0, miClase.calcularCuadrado(0), "Debe entregar un 0 como resultado");
		assertEquals(4, miClase.calcularCuadrado(-2), "Debe entregar un 9 como resultado");
	}

	//Test para evaluar cadenas vacias
	@Test
	void testCadenaVacia() {
		assertTrue(miClase.esCadenaVacia(null)); //Enviando un null 
		assertTrue(miClase.esCadenaVacia("")); //enviando cadena vacia
		assertFalse(miClase.esCadenaVacia("Hola")); //Enviando texto.
	}
}

