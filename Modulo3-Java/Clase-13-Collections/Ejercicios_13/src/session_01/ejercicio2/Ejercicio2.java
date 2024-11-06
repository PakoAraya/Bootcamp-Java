package session_01.ejercicio2;

import java.util.List;
import java.util.stream.Collectors;


/* INSTRUCCIONES
Ejercicio 2: Usando map para generar objetos de otra clase
Objetivo: Aplicar map para convertir elementos de un tipo en objetos de otra clase.
Instrucciones:
1. Crea una lista de nombres (tipo String).																										√
2. Usa map para convertir cada nombre en un objeto de la clase Persona (la clase
tiene un atributo nombre).
3. Almacena los objetos resultantes en una lista.
4. Imprime los nombres de las personas desde la nueva lista. (Collector)

List<String> nombres = List.of("Juan" , "Ana" , "Carlos" , "Marta");
class Persona {
	String nombre;
	public Persona(String nombre) {
		this.nombre = nombre;
  }
}

 */
public class Ejercicio2 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Juan", "Ana", "Carlos", "Marta");

		//Usando MAP para convertir en objeto cada nombre
		List<Persona> personas = nombres
				.stream()
				.map(persona -> new Persona(persona))
				.collect(Collectors.toList()); 


		//Imprimiendo los nombres de las personas en nueva lista.
		System.out.println("El nuevo listado de personas es: " + personas);
	}
}

//Clase persona con sus atributos 
class Persona{
	private String nombre;

	//Constructor de la clase
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	//Getters para el nombre
	public String getNombre() {
		return nombre;
	}

	//Sobreescribir el metodo toString
	@Override
	public String toString() {
		return nombre; 
	}
}
