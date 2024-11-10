package session_15;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ProgramaDeChistes {

	// Instancia de Gson para procesar JSON
	private static final Gson gson = new Gson();

	// Método para obtener un chiste al azar
	public static void obtenerChisteAlAzar() {
		try {
			URL url = new URL("https://official-joke-api.appspot.com/random_joke");
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setRequestProperty("Accept", "application/json");

			if (conexion.getResponseCode() == 200) { // Verificamos que la conexión sea exitosa
				BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				StringBuilder respuesta = new StringBuilder();
				String linea;
				while ((linea = lector.readLine()) != null) {
					respuesta.append(linea);
				}
				lector.close();

				// Convertimos la respuesta en un objeto JSON usando Gson
				JsonObject chiste = gson.fromJson(respuesta.toString(), JsonObject.class);

				// Mostramos el chiste
				System.out.println("Chiste: " + chiste.get("setup").getAsString());
				System.out.println("Respuesta: " + chiste.get("punchline").getAsString());
			} else {
				System.out.println("Error en la conexión. Código de respuesta: " + conexion.getResponseCode());
			}

			conexion.disconnect(); // Cerramos la conexión
		} catch (Exception e) {
			System.out.println("Error al obtener el chiste: " + e.getMessage());
		}
	}

	// Método para obtener diez chistes al azar
	public static void obtenerDiezChistesAlAzar() {
		try {
			URL url = new URL("https://official-joke-api.appspot.com/random_ten");
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setRequestProperty("Accept", "application/json");

			BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			StringBuilder respuesta = new StringBuilder();
			String linea;
			while ((linea = lector.readLine()) != null) {
				respuesta.append(linea);
			}
			lector.close();

			// Convertimos la respuesta en un arreglo JSON usando Gson
			JsonArray chistesArray = gson.fromJson(respuesta.toString(), JsonArray.class);
			for (int i = 0; i < chistesArray.size(); i++) {
				JsonObject chiste = chistesArray.get(i).getAsJsonObject();
				System.out.println("Chiste " + (i + 1) + ": " + chiste.get("setup").getAsString());
				System.out.println("Respuesta: " + chiste.get("punchline").getAsString());
				System.out.println();
			}

			conexion.disconnect(); // Cerramos la conexión
		} catch (Exception e) {
			System.out.println("Error al obtener los chistes: " + e.getMessage());
		}
	}

	// Método main para mostrar el menú
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		System.out.println("Bienvenido al programa de práctica");
		do {
			System.out.println("Opciones:");
			System.out.println("1- Una broma al azar.");
			System.out.println("2- 10 Bromas al azar.");
			System.out.println("3- Salir del programa");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("\nObteniendo un chiste al azar...");
				obtenerChisteAlAzar();
				break;
			case 2:
				System.out.println("\nObteniendo 10 chistes al azar...");
				obtenerDiezChistesAlAzar();
				break;
			case 3:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
			}
			System.out.println();
		} while (opcion != 3);

		scanner.close();
	}
}
