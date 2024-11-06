package session_02.consolidado;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio {
	// ArrayList para almacenar la lista de alumnos
	static ArrayList<Alumno> listaAlumnos = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	public static String lista_alumnos = "/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-13-Collections/Ejercicios_13/src/session_02/consolidado/lista_alumnos.txt";

	public static void main(String[] args) {
		//Para mostrar y elegir una opcion, trabajar con un switch
		int opcion;
		boolean continuar = true;
		while (continuar){
			mostrarMenu();
			opcion = validarOpcion();

			switch (opcion) {
			case 1:
				mostrarLista();
				break;
			case 2:
				agregarAlumno();
				break;
			case 3:
				eliminarAlumno();
				break;
			case 4:
				guardarEnArchivo(listaAlumnos, lista_alumnos);
				break;
			case 5:
				System.out.println("******* SALIENDO DEL PROGRAMA... *******");
				continuar = false;
				break;
			default:
				System.out.println("Has escogido una opción no válida.");
				break;
			}
		}
	}

	//Validar que el ingreso de las opciones este controlado
	public static int validarOpcion(){
		try{
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			//throw new RuntimeException(e.getMessage());
			System.out.println("Entrada inválida, ingresa un número..." + e.getMessage());
			return -1;
		}
	}

	// Mostrar el menú de opciones
	public static void mostrarMenu() {
		System.out.println("\n--- Menú Principal ---");
		System.out.println("1. Mostrar lista de alumnos");
		System.out.println("2. Agregar un alumno");
		System.out.println("3. Eliminar un alumno por RUT");
		System.out.println("4. Guardar lista en archivo");
		System.out.println("5. Salir");
		System.out.print("Seleccione una opción: ");
	}

	// Mostrar la lista de alumnos
	public static void mostrarLista() {
		if(listaAlumnos.isEmpty()){
			System.out.println("La lista de alumnos esta vacía...");
		}else{
			System.out.println("\n--- Lista de Alumnos ---");
			//Foreach para recorrer
			for (Alumno alumno:listaAlumnos) {
				System.out.println(alumno);
			}
		}
	}

	// Agregar un alumno a la lista
	public static void agregarAlumno() {
		System.out.print("Ingrese el nombre del alumno: ");
		String nombre = scanner.nextLine().trim();

		if (nombre.isEmpty()) {
			System.out.println("El nombre no puede estar vacío.");
			return;
		}

		System.out.print("Ingrese el RUT del alumno (sin dígito verificador): ");
		String rut = scanner.nextLine().trim();

		if (rut.isEmpty()) {
			System.out.println("El RUT no puede estar vacío.");
			return;
		}

		// Validar que el RUT no esté repetido
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getRut().equals(rut)) {
				System.out.println("El RUT ya está registrado.");
				return;
			}
		}

		listaAlumnos.add(new Alumno(nombre, rut));
		System.out.println("Alumno agregado correctamente.");
	}

	// Eliminar un alumno buscando por RUT
	public static void eliminarAlumno() {
		System.out.print("Ingrese el RUT del alumno a eliminar (sin dígito verificador): ");
		String rut = scanner.nextLine().trim();

		if (rut.isEmpty()) {
			System.out.println("El RUT no puede estar vacío.");
			return;
		}

		boolean encontrado = false;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getRut().equals(rut)) {
				listaAlumnos.remove(alumno);
				System.out.println("Alumno eliminado correctamente.");
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Alumno no encontrado.");
		}
	}

	// Guardar la lista de alumnos en un archivo de texto (FileWriter)
	public static <T> void guardarEnArchivo(ArrayList<T> lista, String lista_alumnos) {
		try (FileWriter fw = new FileWriter(lista_alumnos, true); // true: Añadir al archivo
				PrintWriter pw = new PrintWriter(fw)) {
			for (T valor : lista) {
				pw.println(valor.toString());
			}
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo: " + e.getMessage());
		}
	}
}

