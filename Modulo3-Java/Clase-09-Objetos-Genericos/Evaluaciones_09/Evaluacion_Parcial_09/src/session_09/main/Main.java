package session_09.main;

import session_09.modelos.Persona;
import session_09.modelos.Alumno;
import session_09.modelos.Profesor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Crear lista para almacenar los individuos
		List<Persona> individuos = new ArrayList<>();

		// Crear datos de prueba
		Profesor profesor1 = new Profesor("Juan Perez", new Date(80, 4, 15)); // 15 de mayo de 1980
		Alumno alumno1 = new Alumno("Maria Garcia", new Date(102, 2, 20), List.of("Matemáticas", "Historia"));
		Alumno alumno2 = new Alumno("Pedro Gomez", new Date(104, 6, 12), List.of("Química", "Física"));
		Profesor profesor2 = new Profesor("Ana Ruiz", new Date(75, 11, 8)); // 8 de diciembre de 1975

		// Agregar individuos a la lista
		individuos.add(profesor1);
		individuos.add(alumno1);
		individuos.add(alumno2);
		individuos.add(profesor2);

		// Imprimir si es Alumno o Profesor y su nombre
		System.out.println("Tipo y Nombre de Individuos:");
		for (Persona individuo : individuos) {
			if (individuo instanceof Profesor) {
				System.out.println("Profesor: " + individuo.getNombre());
			} else if (individuo instanceof Alumno) {
				System.out.println("Alumno: " + individuo.getNombre());
			}
		}

		// Imprimir la superclase correspondiente a cada individuo
		System.out.println("\nSuperclase de cada Individuo:");
		for (Persona individuo : individuos) {
			System.out.println(individuo.getNombre() + " es instancia de: " + individuo.getClass().getSuperclass().getSimpleName());
		}

		// Imprimir la lista completa de individuos
		System.out.println("\nLista Completa de Individuos:");
		for (Persona individuo : individuos) {
			System.out.println(individuo);
		}
	}
}