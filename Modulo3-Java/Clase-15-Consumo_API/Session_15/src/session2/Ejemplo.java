package session2;


/*
 * INSTRUCCIONES
Realiza una consulta a la siguiente URL usando el método GET:
String url = "https://jsonplaceholder.typicode.com/users";
• Muestra la lista de usuarios obtenidos.  √
• Permite que el cliente elija un usuario introduciendo su ID a través de la
consola.  √
• Con la opción ingresada, genera una nueva solicitud para obtener los detalles
del usuario seleccionado:
String url2 = "https://jsonplaceholder.typicode.com/users/" + opcion;
• Finalmente, muestra en la consola el nombre de la compañía (company)
asociada al usuario escogido.
 */



import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import com.google.gson.Gson;

public class Ejemplo {

	public static HttpResponse<String> generarGetRequest(String url) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	public static <T> ArrayList<T> deserializar(String jsonResponse, Class<T[]> clase) {
		Gson gson = new Gson();
		T[] array = gson.fromJson(jsonResponse, clase);
		return new ArrayList<>(Arrays.asList(array));
	}

	// Metodo Generico para deserializar Objeto
	public static <T> T deserializadorObjeto (String jsonResponse, Class<T> clase) {
		return new Gson().fromJson(jsonResponse, clase);
	}

	public static void main(String[] args) {
		String url = "https://jsonplaceholder.typicode.com/users";

		try {
			HttpResponse<String> response = generarGetRequest(url);

			if (response.statusCode() == 200) {
				ArrayList<Usuario> usuarios = deserializar(response.body(), Usuario[].class);
				System.out.println("Lista completa de usuarios: "+usuarios);

				Scanner scanner = new Scanner(System.in);
				System.out.println("\nIngrese el numero de id que desea seleccionar: ");
				int id = scanner.nextInt();

				System.out.println("El id escogido fue: " + id);
				//Generar nueva request para obtener la informacion
				String url2 = "https://jsonplaceholder.typicode.com/users/" + id;
				HttpResponse<String> response2 = generarGetRequest(url2);
				System.out.println(response2.body());

				//Transformar el texto plano que estamos recibiendo del JSON
				if (response2.statusCode() == 200) {    
					//Usuario usuario = deserializar(response2.body(), Usuario[].class).get(0);
					//Usuario usuarioEncontrado = new Gson().fromJson(response2.body(), Usuario.class);
					Usuario usuarioEncontrado = deserializadorObjeto(response2.body(), Usuario.class);
					System.out.println("Detalles del usuario seleccionado: " + usuarioEncontrado);    
					System.out.println("Nombre de la compañía: " + usuarioEncontrado.getCompany().getName());
				} else {    
					System.out.println("Error al obtener los detalles del usuario");
				}


			} else {
				System.out.println("Error en la consulta");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}


class Usuario {
	private String email;
	private String name;
	private int id;
	public Company company;


	public Usuario(String email, String name, int id) {
		this.email = email;
		this.name = name;
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "\nid=" + id + " email= " + email + ", name= '" + name + "'";
	}
}

class Company{
	public String name;

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
