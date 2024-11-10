package session1;

/*
 * Hoy veremos interaccion con API
 * Para que el proyecto funcione, se debe adjuntar la liberia externa gson.jar
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


public class Ejemplo {
	public static void main(String[] args) {
		//System.out.println("Hola");
		//Lo primero que hay que hacer es crear un objeto para generar solicitudes o consultas de tipo HttpClient
		//Permite generar las consultas
		HttpClient client = HttpClient.newHttpClient();

		//Permite generar las solicitudes http, por defecto trabaja el get() (se puede escribir o no)
		//Lo que nosotros vamos a solicitar lo vamos a colocar en el request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://jsonplaceholder.typicode.com/users"))
				//.PUT() .POST() .GET()...
				.build();

		//Try-Catch para evitar errores y caidas de app
		try {
			HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response: " + response.body());
			//Vamos a ver el estado de la consulta (status code)
			System.out.println("Estado de la consulta: " + response.statusCode());

			//Y podemos tomar accion en base al status code
			if(response.statusCode() == 200) {
				System.out.println("Consulta exitosa");
				Gson gson = new Gson();
				Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();

				//con esta linea voy a transformar el texto del json a un arraylist que voy a poder manipular
				ArrayList<Usuario> usuarios = gson.fromJson(response.body(), usuarioListType);

				//Vamos a ver como quedo nuestra informacion
				System.out.println("Info: " + usuarios);
				//O podemos pedir uno en particular
				System.out.println("\nInfo Usuario 0: " + usuarios.get(0));

				/*TAREA STREAM LIST
				 * Mostrar la lista completa por consola																					√
				 * por consola pedir al usuario que ingrese un email															√
				 * buscar el email ingresado en nuestra lista																		√
				 * si lo encuentra mostrar objeto por consola // si no indicar que no existe			√
				 * si se encontró el objeto por email eliminar objeto														√
				 * mostrar la lista completa nuevamente por pantalla															
				 */

				//Mostrar la lista completa usando Foreach
				System.out.println("La lista completa de usuarios es: ");
				usuarios.forEach(System.out::println);

				//Por consola pedir al usuario que ingrese un mail
				Scanner scan = new Scanner(System.in);
				System.out.println("\nIngrese el email que quiere buscar: ");
				String emailBuscado = scan.nextLine();

				//Vamos a buscar el email en nuestra lista
				Optional<Usuario> usuariosExistente = usuarios
						.stream()
						.filter(usuario -> usuario.getEmail().equalsIgnoreCase(emailBuscado))
						.findFirst();

				//Vamos a probar optional (Investigar)
				if(usuariosExistente.isPresent()) {
					//Mostrar y Eliminar
					System.out.println("Usuario encontrado: " + usuariosExistente.get());
					//Ahora lo vamos a eliminar con remove
					usuarios.remove(usuariosExistente.get());

				}else {
					//Indicar que el email no esta.
					System.out.println("El usuario con el e-mail " + emailBuscado + " no existe...");
				}
				//Mostrar el listado actualizado de usuarios
				usuarios.forEach(System.out::println);

			}else {
				System.out.println("Error en consulta");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error " + e);
		}
	}
}