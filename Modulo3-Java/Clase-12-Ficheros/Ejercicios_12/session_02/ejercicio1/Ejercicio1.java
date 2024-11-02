package session_02.ejercicio1;
/*
Objetivo: Implementar un programa en Java que permita almacenar y gestionar una
lista de alumnos en un archivo de texto. Cada alumno tendrá un nombre, una edad y                  √
una nota.
Descripción:
1. Crea una clase Alumno con los atributos nombre, edad y nota(PRIVADOS).                          √
2. Implementa un metodo toString() en la clase Alumno para que los datos de                        √
cada alumno puedan guardarse en el archivo en el formato nombre,edad,nota.
3. Implementa un metodo genérico guardar que reciba un archivo(nombre del                          √
archivo) y un objeto y lo guarde en dicho archivo.
4. En la clase principal, permite que el usuario ingrese múltiples alumnos (n alumnos)             √
y guárdalos en un archivo llamado alumnos.txt.
5. Lee el archivo y muestra en consola la lista de alumnos almacenados.
6. Muestre por consola(pantalla) el promedio de todos los estudiantes.

 Pistas:
• Usa FileWriter en modo de adición para escribir en el archivo sin borrar el
contenido anterior. (uso del true)
• Usa BufferedReader para leer el archivo línea por línea.                                          √
• Usa split(",") para dividir el contenido del archivo y reconstruir los objetos                    √
Alumno cuando los leas.
• Investigar uso de. size() de un ArrayList
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	public static String nombreArchivo = "/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-12-Ficheros/Session_12/src/session_02/ejercicio1/alumnos.txt";

	public static void main(String[] args) {
		System.out.println("******* ALUMNOS APP *******");
		Scanner scan = new Scanner(System.in);
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();

		// Preguntar por cuantos alumnos se va a ingresar
		System.out.println("Cuantos alumnos deseas ingresar???: ");
		int cantAlumnos = scan.nextInt();
		// Vamos a limpiar el buffer
		scan.nextLine(); // Recibe cadenas de texto (oracion)

		// Sobrescribir el archivo antes de agregar nuevos datos
		limpiarArchivo();

		for (int i = 0; i < cantAlumnos; i++) {
			System.out.println("Ingrese el nombre del alumno: ");
			String nombre = scan.nextLine();

			System.out.println("Ingrese la edad del alumno: ");
			int edad = scan.nextInt();

			System.out.println("Ingrese la nota del alumno: ");
			double nota = scan.nextDouble();
			scan.nextLine(); // Limpiamos el Scanner.

			// Ver la forma de guardar los datos del alumno
			Alumno alumno = new Alumno(nombre, edad, nota);
			listaAlumnos.add(alumno);
		}

		// Guardar la lista completa de alumnos
		guardar(listaAlumnos);

		// Leer el archivo y mostrar a los alumnos
		ArrayList<Alumno> alumnosLeidos = leerArchivo();
		for (Alumno alumno : alumnosLeidos) {
			System.out.println(alumno);
		}

		// Mostrar el promedio
		if (!alumnosLeidos.isEmpty()) {
			double promedio = calcularPromedio(alumnosLeidos);
			System.out.println("El promedio de las notas de los alumnos es: " + promedio);
		} else {
			System.out.println("No hay alumnos registrados...");
		}
	}

	// Metodo para sobrescribir el archivo limpiando los datos antiguos
	public static void limpiarArchivo() {
		try (FileWriter fw = new FileWriter(nombreArchivo, false);  // false: Sobrescribir el archivo
				PrintWriter pw = new PrintWriter(fw)) {
			// El archivo se sobrescribe al llamarse sin escribir ningún dato aquí
		} catch (IOException e) {
			System.out.println("Error al limpiar el archivo: " + e.getMessage());
		}
	}

	// Metodo para escribir sobre el archivo
	public static <T> void guardar(ArrayList<T> lista) {
		try (FileWriter fw = new FileWriter(nombreArchivo, true); // true: Añadir al archivo
				PrintWriter pw = new PrintWriter(fw)) {
			for (T valor : lista) {
				pw.println(valor.toString());
			}
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo: " + e.getMessage());
		}
	}

	// Leer el archivo de alumnos y mostrarlos
	public static ArrayList<Alumno> leerArchivo() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			FileReader fr = new FileReader(nombreArchivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				String nombre = datos[0].trim();
				int edad = Integer.parseInt(datos[1].trim()); // Convertir a entero
				double nota = Double.parseDouble(datos[2].trim()); // Convertir a decimal
				Alumno alumno = new Alumno(nombre, edad, nota);
				alumnos.add(alumno);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
		return alumnos;
	}

	// Método para calcular el promedio de notas
	public static double calcularPromedio(ArrayList<Alumno> alumnos) {
		double suma = 0;
		for (Alumno alumno : alumnos) {
			suma += alumno.getNota();
		}
		return suma / alumnos.size();
	}
}