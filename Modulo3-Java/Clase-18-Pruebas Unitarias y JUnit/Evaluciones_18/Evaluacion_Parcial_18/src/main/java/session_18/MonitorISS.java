package session_18;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MonitorISS {

	// Método 1: conexionApi
	public static DatosISS conexionApi() {
		try {
			URL url = new URL("http://api.open-notify.org/iss-now.json"); // URL de la API
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setConnectTimeout(5000);
			conexion.setReadTimeout(5000);

			// Leer la respuesta de la API
			InputStreamReader lector = new InputStreamReader(conexion.getInputStream());
			Gson gson = new Gson();
			DatosISS datos = gson.fromJson(lector, DatosISS.class);
			lector.close();

			return datos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Método 2: estadoConexion
	public static String estadoConexion(DatosISS datos) {
		return datos != null ? datos.getEstado() : "Error en la conexión";
	}

	// Método 3: idConexion
	public static String idConexion(DatosISS datos) {
		return datos != null ? String.valueOf(datos.getTimestamp()) : "Error en la conexión";
	}

	// Método 4: obtenerLatitud
	public static double obtenerLatitud(DatosISS datos) {
		return datos != null ? datos.getPosicionIss().getLatitud() : 0;
	}

	// Método 5: obtenerLongitud
	public static double obtenerLongitud(DatosISS datos) {
		return datos != null ? datos.getPosicionIss().getLongitud() : 0;
	}

	public static void main(String[] args) {
		DatosISS datos = conexionApi();

		System.out.println("Estado de la conexión a los servidores de la ISS:");
		System.out.println(estadoConexion(datos));

		System.out.println("ID de la conexión:");
		System.out.println(idConexion(datos));

		System.out.println("Latitud de la Estación Internacional:");
		System.out.println(obtenerLatitud(datos));

		System.out.println("Longitud de la Estación Internacional:");
		System.out.println(obtenerLongitud(datos));
	}
}

