package ejercicio1test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.miappl.ejercicio1.EmailClient;
import com.miappl.ejercicio1.NotificationService;

public class NotificationServiceTest {
	//Creamos una clase Dummy que emule a la clase EmailClient
	public class DummyEmailClient extends EmailClient{
		
	}
	
	@Test
	void testDummy() {
		
		//Cremos un objeto de la clase DummyEmailClient para pasar por parametro a la clase
		//NotificationService (Emulando el comportamiento entre EmailClient y NotificationService)
		DummyEmailClient dummyEmailClient = new DummyEmailClient();
		//Pasamos por parametro el objeto a la clase NotificationService
		NotificationService notificacion = new NotificationService(dummyEmailClient);
		
		//Pruebas (True | False)
		//Si el mensaje es distinto de null y distinto de vacio retorna verdadero (TRUE)
		assertTrue(notificacion.sendNotification("Test"));
		assertFalse(notificacion.sendNotification(""));
		assertFalse(notificacion.sendNotification(null));
	}
}
