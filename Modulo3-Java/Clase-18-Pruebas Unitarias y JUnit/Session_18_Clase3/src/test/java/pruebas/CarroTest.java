package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.miappl.models.Carro;
import com.miappl.models.Motor;

public class CarroTest {
	public class DummyMotor extends Motor{

		@Override
		public boolean encender() {
			return false;
		}

		@Override
		public boolean apagar() {
			return false;
		}
	}

	//Vamos a usar Stub con la clase Motor
	public class StubMotor extends Motor{
		@Override
		public boolean encender() {
			return true;
		}

		@Override
		public boolean apagar() {
			return true;
		}
	}

	@Test
	void testDummy() {
		//Estos objetos son usados para completar una firma de metodo
		//o satisfacer dependencias
		DummyMotor dummy = new DummyMotor();
		Carro carro = new Carro(dummy);
		//Valor objetivo		--metodo
		assertEquals("El carro está apagado", carro.obtenerEstado());
	}

	//Test de Stub
	@Test
	void testStub() {
		/* Los Stubs devuelven datos predefinidos en respuesta a 
		 * llamadas de metodos especificos.
		 * Se usan cuando queremos asegurar que un metodo devuelva un valor particular
		 * durante una prueba.
		 */
		StubMotor stub = new StubMotor();
		Carro carro = new Carro(stub);

		assertTrue(carro.encenderCarro());
	}


}
