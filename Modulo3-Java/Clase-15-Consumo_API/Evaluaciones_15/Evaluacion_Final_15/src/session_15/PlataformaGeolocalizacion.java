package session_15;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PlataformaGeolocalizacion {

	// Instancia de Gson para procesar JSON
	private static final Gson gson = new Gson();

	// Método para obtener datos de geolocalización desde la API
	public static JsonObject obtenerDatosGeolocalizacion() {
		JsonObject resultado = null;
		try {
			// Usamos la URL de la API ip-api.com para obtener los datos de geolocalización
			URL url = new URL("http://ip-api.com/json");  // Cambio la URL a ip-api.com
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setRequestProperty("Accept", "application/json");

			// Leer la respuesta de la API
			BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			StringBuilder respuesta = new StringBuilder();
			String linea;
			while ((linea = lector.readLine()) != null) {
				respuesta.append(linea);
			}
			lector.close();

			// Convertimos la respuesta en un objeto JSON usando Gson
			resultado = gson.fromJson(respuesta.toString(), JsonObject.class);
		} catch (Exception e) {
			// Imprimir el mensaje de error y detalles adicionales para depurar
			System.out.println("Error al obtener los datos de geolocalización: " + e.getMessage());
			e.printStackTrace();  // Esto imprimirá más detalles sobre el error
		}
		return resultado;
	}

	// Método para obtener un valor de un JsonObject con control de nulidad
	private static String obtenerValor(JsonObject json, String clave) {
		if (json != null && json.has(clave)) {
			return json.get(clave).isJsonNull() ? "No disponible" : json.get(clave).getAsString();
		}
		return "No disponible";
	}

	// Método principal para solicitar datos del usuario y mostrar información de geolocalización
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Solicitar datos básicos del usuario
		System.out.print("Ingrese el nombre del usuario: ");
		String nombre = scanner.nextLine();

		System.out.print("Ingrese el apellido del usuario: ");
		String apellido = scanner.nextLine();

		System.out.print("Ingrese el email del usuario: ");
		String email = scanner.nextLine();

		// Obtener datos de geolocalización
		System.out.println("\nObteniendo datos de geolocalización...");
		JsonObject datosGeolocalizacion = obtenerDatosGeolocalizacion();

		// Mostrar la información del usuario y la geolocalización
		if (datosGeolocalizacion != null) {
			System.out.println("\n--- Información del Usuario ---");
			System.out.println("Nombre: " + nombre);
			System.out.println("Apellido: " + apellido);
			System.out.println("Email: " + email);

			System.out.println("\n--- Información de Geolocalización ---");
			System.out.println("IP: " + obtenerValor(datosGeolocalizacion, "ip"));
			System.out.println("País: " + obtenerValor(datosGeolocalizacion, "country"));
			System.out.println("Región: " + obtenerValor(datosGeolocalizacion, "regionName"));
			System.out.println("Ciudad: " + obtenerValor(datosGeolocalizacion, "city"));
			System.out.println("Código Postal: " + obtenerValor(datosGeolocalizacion, "zip"));
			System.out.println("Latitud: " + obtenerValor(datosGeolocalizacion, "lat"));
			System.out.println("Longitud: " + obtenerValor(datosGeolocalizacion, "lon"));
		} else {
			System.out.println("No se pudo obtener la información de geolocalización.");
		}

		scanner.close();
	}
}