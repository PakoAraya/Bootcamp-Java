package test_session18;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import session_18.DatosISS;
import session_18.MonitorISS;

public class ISSMonitorTest {

	@Test
	public void pruebaEstadoConexión() {
		DatosISS datos = new DatosISS();
		datos.setEstado("success");
		assertEquals("success", MonitorISS.estadoConexion(datos));
	}

	@Test
	public void pruebaIdConexión() {
		DatosISS datos = new DatosISS();
		datos.setTimestamp(1605891577);
		assertEquals("1605891577", MonitorISS.idConexion(datos));
	}

	@Test
	public void pruebaInfoLat() {
		DatosISS datos = new DatosISS();
		DatosISS.Posicion pos = new DatosISS.Posicion();
		pos.setLatitud(14.2386);
		datos.setPosicionIss(pos);
		assertEquals(14.2386, MonitorISS.obtenerLatitud(datos));
	}

	@Test
	public void pruebaInfoLong() {
		DatosISS datos = new DatosISS();
		DatosISS.Posicion pos = new DatosISS.Posicion();
		pos.setLongitud(-9.4583);
		datos.setPosicionIss(pos);
		assertEquals(-9.4583, MonitorISS.obtenerLongitud(datos));
	}
}