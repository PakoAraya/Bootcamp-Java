package session_14;

/*
Programa: GestorAlumno con Validaciones de Entrada
Descripción: Este programa debe gestionar alumnos, validando que el nombre no
esté vacío, que la edad sea mayor a 0 y que la nota esté en el rango de 1 a 7. Si alguna
entrada no cumple con estas condiciones, se lanza una excepción específica para
que el usuario pueda corregir el error.
Validar metodo guardar(), donde no debe permitir guardar texto vacio.
Reglas de Validación
1. Nombre: No puede estar vacío.                     √
2. Edad: Debe ser un número mayor a 0.               √
3. Nota: Debe estar comprendida entre 1 y 7.         √
TIP: investigar IllegalArgumentException
Validar metodo guardar(), donde no debe permitir guardar texto vacio.        √
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import session_14.Alumno;

public class GestorAlumno {
	public static String nombreArchivo = "/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-14-Excepciones/Ejercicios_14/numeros.txt";

	public static void main(String[] args) {
		System.out.println("Lectura y escritura de Alumnos:");

		Scanner scanner = new Scanner(System.in);

		try {
			for (int i = 0; i < 3; i++) {
				System.out.println("Ingrese el nombre de la persona:");
				String nombre = scanner.nextLine();
				validarNombre(nombre);

				System.out.print("Ingrese la edad: ");
				int edad = scanner.nextInt();
				validarEdad(edad);

				scanner.nextLine(); // Consumir la línea restante del buffer

				System.out.print("Ingrese la nota: ");
				double nota = scanner.nextDouble();
				validarNota(nota);

				scanner.nextLine(); // Consumir la línea restante del buffer

				Alumno alumno = new Alumno(nombre, edad, nota);

				guardar(alumno);
			}

			ArrayList<Alumno> alumnoLectura = lectura();
			mostrar(alumnoLectura);
			calcularPromedio(alumnoLectura);
		} catch (Exception e) {
			System.out.println("Error general: " + e.getMessage());
		}
	}

	public static void calcularPromedio(ArrayList<Alumno> listaAlumnos) throws Exception {
		if (listaAlumnos.size() <= 1) {
			throw new Exception("La lista debe contener más de un alumno para calcular el promedio.");
		}
		double notasSum = listaAlumnos.stream().mapToDouble(Alumno::getNota).sum();
		double promedio = notasSum / listaAlumnos.size();
		System.out.println("El promedio general es " + promedio);
	}

	public static <T> void mostrar(ArrayList<T> lista) {
		lista.forEach(System.out::println);
	}

	public static <T> void guardar(T valor) {
		if (valor == null) {
			throw new IllegalArgumentException("No se puede guardar objetos vacíos.");
		}
		try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo, true))) {
			pw.println(valor.toString());
		} catch (IOException e) {
			System.out.println("Error al guardar en el archivo: " + e.getMessage());
		}
	}

	public static ArrayList<Alumno> lectura() {
		ArrayList<Alumno> alumnoList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				Alumno alumno = new Alumno(
						partes[0].trim(),
						Integer.parseInt(partes[1].trim()),
						Double.parseDouble(partes[2].trim())
						);
				alumnoList.add(alumno);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
		return alumnoList;
	}

	public static void validarNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío.");
		}
	}

	public static void validarEdad(int edad) {
		if (edad <= 0) {
			throw new IllegalArgumentException("La edad debe ser mayor a 0.");
		}
	}

	public static void validarNota(double nota) {
		if (nota < 1 || nota > 7) {
			throw new IllegalArgumentException("La nota debe estar entre 1 y 7.");
		}
	}
}