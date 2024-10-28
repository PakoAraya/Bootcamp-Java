package session_06;

import java.util.ArrayList;
import java.util.Scanner;

class Persona {
	private String nombreUsuario;
	private String contrasena;
	private String nombreCompleto;
	private String fechaNacimiento;

	public Persona(String nombreUsuario, String contrasena, String nombreCompleto, String fechaNacimiento) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean esMayorDeEdad() {
		String[] fecha = fechaNacimiento.split("-");
		int anioNacimiento = Integer.parseInt(fecha[0]);
		int anioActual = java.time.Year.now().getValue();
		return (anioActual - anioNacimiento) >= 18;
	}

	public static boolean validarContrasena(String contrasena) {
		if (contrasena.length() < 10) {
			System.out.println("La contraseña debe tener más de 10 caracteres.");
			return false;
		}

		int mayusculas = 0;
		int numerosOSimbolos = 0;

		for (char c : contrasena.toCharArray()) {
			if (Character.isUpperCase(c)) {
				mayusculas++;
			} else if (Character.isDigit(c) || !Character.isLetterOrDigit(c)) {
				numerosOSimbolos++;
			}
		}

		if (mayusculas < 2) {
			System.out.println("La contraseña debe contener al menos 2 letras mayúsculas.");
			return false;
		}

		if (numerosOSimbolos < 3) {
			System.out.println("La contraseña debe contener al menos 3 caracteres que sean números o símbolos.");
			return false;
		}

		return true;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Persona> listaUsuarios = new ArrayList<>();
		int maxUsuarios = 10;

		while (listaUsuarios.size() < maxUsuarios) {
			System.out.println("Registro de un nuevo usuario:");

			System.out.print("Nombre de usuario: ");
			String nombreUsuario = scanner.nextLine();

			System.out.print("Contraseña: ");
			String contrasena = scanner.nextLine();

			if (!Persona.validarContrasena(contrasena)) {
				System.out.println("Registro fallido. Intente de nuevo.");
				continue;
			}

			System.out.print("Nombre completo: ");
			String nombreCompleto = scanner.nextLine();

			System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
			String fechaNacimiento = scanner.nextLine();

			Persona nuevoUsuario = new Persona(nombreUsuario, contrasena, nombreCompleto, fechaNacimiento);
			listaUsuarios.add(nuevoUsuario);

			System.out.println("Usuario registrado correctamente.");

			if (nuevoUsuario.esMayorDeEdad()) {
				System.out.println("El usuario es mayor de edad.");
			} else {
				System.out.println("El usuario es menor de edad.");
			}

			System.out.println("Usuarios registrados: " + listaUsuarios.size() + "/" + maxUsuarios);
		}

		scanner.close();
		System.out.println("Se ha alcanzado el límite de usuarios registrados.");
	}
}
