package session_06;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

class Persona {
	private String usuario;
	private String contrasena;

	// Constructor
	public Persona(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	// Métodos getters
	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Crear una lista de personas
		ArrayList<Persona> listaPersonas = new ArrayList<>();

		// Añadir algunas personas a la lista (simulando una "base de datos")
		listaPersonas.add(new Persona("usuario1", "password1"));
		listaPersonas.add(new Persona("usuario2", "password2"));
		listaPersonas.add(new Persona("usuario3", "password3"));

		// Solicitar usuario y contraseña
		System.out.print("Ingrese su usuario: ");
		String inputUsuario = scanner.nextLine();
		System.out.print("Ingrese su contraseña: ");
		String inputContrasena = scanner.nextLine();

		// Verificar si el usuario y la contraseña coinciden con alguno en la lista
		boolean accesoPermitido = false;
		for (Persona persona : listaPersonas) {
			if (persona.getUsuario().equals(inputUsuario) && persona.getContrasena().equals(inputContrasena)) {
				accesoPermitido = true;
				break;
			}
		}

		// Si el acceso es permitido, mostrar el menú
		if (accesoPermitido) {
			int opcion = 0;
			do {
				System.out.println("\n--- MENÚ ---");
				System.out.println("1. Calcular la raíz cuadrada de un número");
				System.out.println("2. Ver el valor de Pi");
				System.out.println("3. Calcular la potencia de un número");
				System.out.println("4. Salir");
				System.out.print("Elija una opción: ");
				opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					// Calcular la raíz cuadrada
					System.out.print("Ingrese un número para calcular la raíz cuadrada: ");
					double numero = scanner.nextDouble();
					System.out.println("La raíz cuadrada de " + numero + " es: " + Math.sqrt(numero));
					break;
				case 2:
					// Mostrar el valor de Pi
					System.out.println("El valor de Pi es: " + Math.PI);
					break;
				case 3:
					// Calcular la potencia
					System.out.print("Ingrese la base: ");
					double base = scanner.nextDouble();
					System.out.print("Ingrese el exponente: ");
					double exponente = scanner.nextDouble();
					System.out.println(base + " elevado a la potencia de " + exponente + " es: " + Math.pow(base, exponente));
					break;
				case 4:
					System.out.println("Saliendo del menú...");
					break;
				default:
					System.out.println("Opción no válida. Intente nuevamente.");
				}
			} while (opcion != 4);
		} else {
			System.out.println("Usuario o contraseña incorrectos. Acceso denegado.");
		}

		scanner.close();
	}
}

