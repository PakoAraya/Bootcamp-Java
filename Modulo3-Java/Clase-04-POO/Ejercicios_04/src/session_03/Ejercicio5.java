package session_03;

//Ejercicio 5: Interacción de Clases Profesor y Curso 3pts
//Crea una clase Profesor con los siguientes atributos:
//• nombre (String)
//• edad (int)
//• especialidad (String)
//• salario (double)
//• curso (de tipo Curso)
//Crea una clase Curso con los atributos:
//• nombreCurso (String)
//• duracion (int) en horas
//Métodos:
//• Sobrecarga el metodo toString() en ambas clases para mostrar la información
//del profesor y el curso.

public class Ejercicio5 {
	public static void main(String[] args) {
		Profesor profesor1 = new Profesor("Juan", 35, "Ingeniería en Sistemas", 20000, "Java");
		Curso curso1 = new Curso("Java Avanzado", 36);

		System.out.println(profesor1.toString());
		System.out.println(curso1.toString());
	}
}

class Profesor{
	String nombre;
	int edad;
	String especialidad;
	double salario;
	String curso;

	// Constructor
	Profesor(String nombre, int edad, String especialidad, double salario, String curso){
		this.nombre = nombre;
		this.edad = edad;
		this.especialidad = especialidad;
		this.salario = salario;
		this.curso = curso;
	}

	//Metodo toString

	@Override
	public String toString(){
		return ("Profesor: " + nombre + ", edad: " + edad + ", especialidad: " + especialidad + ", salario: " + salario + ", curso: " + curso);
	}
}

class Curso{
	String nombre;
	int duracion;

	// Constructor

	Curso(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}

	// Metodo toString

	@Override
	public String toString(){

		return ("Curso: " + nombre + ", duracion: " + duracion);
	}
}
