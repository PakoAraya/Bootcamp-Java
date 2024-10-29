package session_08;

import java.util.ArrayList;
import java.util.List;

public class ListaCurso {
	public static void main(String[] args) {
		// Crear un profesor
		Profesor profesor = new Profesor("Dr. Pérez", 101, "Matemáticas");

		// Crear algunos alumnos
		Alumno alumno1 = new Alumno("Juan", 201, profesor, "Fútbol");
		Alumno alumno2 = new Alumno("María", 202, profesor, "Lectura");
		Alumno alumno3 = new Alumno("Carlos", 203, profesor, "Música");

		// Lista para almacenar al profesor y los alumnos
		List<CursoMiembro> listaCurso = new ArrayList<>();
		listaCurso.add(profesor);
		listaCurso.add(alumno1);
		listaCurso.add(alumno2);
		listaCurso.add(alumno3);

		// Mostrar los datos del curso
		System.out.println("Listado de Miembros del Curso:");
		for (CursoMiembro miembro : listaCurso) {
			miembro.mostrarDatos();
		}
	}
}