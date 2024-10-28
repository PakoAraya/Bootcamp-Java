package session_02;

/*1. Ejercicio 1:
//Crea una clase Estudiante con los atributos nombre y edad.
//Sobrecarga el metodo toString() para devolver una cadena con la
//información del estudiante. */

public class Ejercicio1 {
	public static void main(String[] args){
		//Crear objetos de tipo Estudiante
		Estudiante estudiante1 = new Estudiante("Michael",23 );
		Estudiante estudiante2 = new Estudiante("Maria", 28);

		//Vamos a imprimir usando toString
		System.out.println("Estudiante 1 usando toString: " + estudiante1.toString());
		System.out.println("Estudiante 2 sin to String: " + estudiante2);
	}
}

class Estudiante{
	String nombre;
	int edad;

	//Constructor
	public Estudiante(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}

	//Metodo toString
	//Override
	@Override
	public String toString(){
		return ("Estudiante: " + nombre + ", edad: " + edad);
	}

	//Metodo toString basico que retorna solo el nombre
	public String devolverNombre(){
		return nombre;
	}

	//Metodo que devuelve solo la edad
	public int devolverEdad(){
		return edad;
	}

}
