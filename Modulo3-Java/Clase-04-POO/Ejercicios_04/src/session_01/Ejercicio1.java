package session_01;

//Ejercicio 1: Clase Persona
//Crea una clase llamada Persona que tenga los siguientes atributos:
//• nombre (String)
//• edad (int)
//• genero (char)
//Requisitos:
//• Crea un constructor que reciba todos los atributos como parámetros.

public class Ejercicio1 {
	public static void main(String[] args) {
		Persona persona1 = new Persona("Felipe",36,'M');
		System.out.println("Nombre: " + persona1.nombre);
		System.out.println("Edad: " + persona1.edad);
		System.out.println("Genero: " + persona1.genero);
	}
}

class Persona{
	String nombre;
	int edad;
	char genero;

	//Constructor con todos los atributos como parametros
	Persona(String nombre, int edad, char genero){
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
	}
}