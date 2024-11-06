package session_03.ejercicio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * INSTRUCCIONES
Ejercicio 3: Registro de calificaciones Crea un programa que registre las
calificaciones de 5 estudiantes (en el código) usando un Map. Luego, permite al
usuario buscar la calificación de un estudiante específico. Si no es encontrado genera
un mensaje indicando que no existe alumno.
Requisitos:
• Añadir 5 estudiantes con sus respectivas calificaciones.																				√
• Permitir buscar la calificación de un estudiante usando su nombre.															√												
 */
public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Crear un mapa para almacenar las calificaciones
		Map<String, Double> calificaciones = new HashMap<>();

		// Añadir 5 estudiantes con sus respectivas calificaciones
		calificaciones.put("Mario", 6.4);
		calificaciones.put("Jacky", 6.9);
		calificaciones.put("Eduardo", 4.5);
		calificaciones.put("Renata", 3.2);
		calificaciones.put("Anita", 5.8);

		// Pedir al usuario que ingrese el nombre, para ello, primero mostraremos el listado de alumnos
		System.out.println("Listado de estudiantes: ");
		calificaciones.forEach((estudiante, nota) -> System.out.println("- " + estudiante));

		System.out.println("Ingresa el nombre del alumno para ver evaluación: ");
		String nombreAlumno = scan.nextLine();

		// Obtener la calificación del estudiante
		Double calificacion = calificaciones.get(nombreAlumno); // Aquí no se necesita 'new'

		// Evaluar si viene null o no el dato que le ingresamos
		if (calificacion != null) {
			System.out.println("La calificación de " + nombreAlumno + " es: " + calificacion);
		} else {
			System.out.println("El estudiante: " + nombreAlumno + " no existe en el registro...");
		}
	}
}