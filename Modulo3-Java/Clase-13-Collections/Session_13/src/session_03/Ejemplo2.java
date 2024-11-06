package session_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Este ejemplo ve los HashMap
public class Ejemplo2 {
	public static void main(String[] args) {
		//MAP
		//PUT Guarda la clave y el valor dentro del Hashmap
		//GET rescata los valores en base a la clave

		ArrayList<Alumn> alumnos = new ArrayList<Alumn>();
		alumnos.add(new Alumn("Juan", 85));
		alumnos.add(new Alumn("Ana", 85));
		alumnos.add(new Alumn("Juan", 85));

		//Recordemos que el Hasmap funciona como JSon con el concepto de clave y valor.
		Map<String, Integer> calificaciones = new HashMap<>();
		//Debemos recorrerlo en primera instancia para que encuentre los valores
		for (Alumn alumno : alumnos) {
			calificaciones.put(alumno.getNombre(), alumno.getNota());
		}
		System.out.println("Todas las calificaciones: " + calificaciones);
		System.out.println("Obtener a Juan: " + calificaciones.get("Juan"));
	}
}

class Alumn{
	private String nombre;
	private int nota;

	//Constructor de la clase
	public Alumn(String nombre, int nota) {
		this.nombre = nombre;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "Nombre " + nombre + " nota: " + nota;
	}
}
