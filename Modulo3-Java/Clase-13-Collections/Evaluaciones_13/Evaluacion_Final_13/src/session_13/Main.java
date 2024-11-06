package session_13;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		CentroEstudios centro = new CentroEstudios();
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		// Ejemplo de datos iniciales
		centro.agregarCurso(new Curso("Matemáticas", "MAT101", "Curso de Matemáticas Básicas"));
		centro.agregarAlumno(new Alumno("Juan Pérez", "12345678-9", LocalDate.of(2000, 5, 15)));

		while (!salir) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. Mostrar cursos disponibles");
			System.out.println("2. Matricular nuevo alumno");
			System.out.println("3. Agregar nuevo curso");
			System.out.println("4. Asignar curso a un alumno");
			System.out.println("5. Ver lista completa de cursos y alumnos matriculados");
			System.out.println("6. Cerrar aplicación");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la línea

			switch (opcion) {
			case 1:
				centro.mostrarCursos();
				break;
			case 2:
				System.out.print("Nombre del alumno: ");
				String nombre = scanner.nextLine();
				System.out.print("RUT del alumno: ");
				String rut = scanner.nextLine();
				System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
				LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
				centro.agregarAlumno(new Alumno(nombre, rut, fechaNacimiento));
				break;
			case 3:
				System.out.print("Nombre del curso: ");
				String nombreCurso = scanner.nextLine();
				System.out.print("Código del curso: ");
				String codigoCurso = scanner.nextLine();
				System.out.print("Descripción del curso: ");
				String descripcionCurso = scanner.nextLine();
				centro.agregarCurso(new Curso(nombreCurso, codigoCurso, descripcionCurso));
				break;
			case 4:
				System.out.print("Código del curso: ");
				String codigo = scanner.nextLine();
				System.out.print("RUT del alumno: ");
				String rutAlumno = scanner.nextLine();
				centro.asignarCursoAAlumno(codigo, rutAlumno);
				break;
			case 5:
				centro.verMatriculas();
				break;
			case 6:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}
		scanner.close();
	}
}