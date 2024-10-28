package ejercicio2;

//Ejercicio 2: Clase Persona y Clase Estudiante
//Enunciado:
//Crea una clase Persona que tenga un atributo nombre y un metodo saludar() que         √
//imprima un saludo genérico con el nombre.
//
//Luego, crea una clase hija Estudiante que
//sobrescriba el metodo saludar() para imprimir un mensaje más específico, pero         √
//invocando el metodo de la clase padre usando super.

public class Ejercicio2 {
	public static void main(String[] args) {
		Persona persona1 = new Persona("Pedro");
		persona1.saludar();

		Estudiante estudiante1 = new Estudiante("Ana");
		estudiante1.setApellido("Dominguez");
		estudiante1.saludar();
		System.out.println("y mi apellido es: " + estudiante1.getApellido());
	}
}
