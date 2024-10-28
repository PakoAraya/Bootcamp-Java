package session_02;

//Ejercicio 3:
//o Crea dos clases: Libro y Autor.
//o La clase Autor tendrá los atributos nombre y nacionalidad. Sobrecarga
//el metodo toString() para mostrar esta información.
//o La clase Libro tendrá los atributos titulo y un objeto Autor. Sobrecarga el
//metodo toString() en la clase Libro para mostrar la información del libro
//y del autor.

public class Ejercicio3 {
	public static void main(String[] args){
		//Creacion de los objetos
		//Objeto de prueba 1
		Autor autor1 = new Autor("Gabriel Garcia Marquez", "Venezolano");
		Libro libro1 = new Libro("Las 50 sombras de Grey",autor1);

		//Objeto de prueba 2
		Autor autor2 = new Autor("J.K. Rowling", "Britanica");
		Libro libro2 = new Libro("Harry Potter y la orden del Caballero del Fenix", autor2);

		//Vamos a imprimir los resultados
		System.out.println("Datos libro1: " + libro1);
		System.out.println("Datos libro2: " + libro2);
	}
}

//Clase autor
class Autor{
	//Atributos
	String nombre;
	String nacionalidad;

	//Constructor clase autor
	Autor (String nombre, String nacionalidad){
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	//Metodo toString clase autor
	@Override
	public String toString(){
		return("Autor: " + nombre + ", Nacionalidad: " + nacionalidad);
	}
}

//Clase Libro
class Libro{
	//Atributos
	String titulo;
	Autor autor;

	//Constructor de la clase Libro
	Libro(String titulo, Autor autor){
		this.titulo = titulo;
		this.autor = autor;
	}

	//Metodo toString clase libro
	@Override
	public String toString(){
		return "Titulo: " + titulo + ", " + autor.toString();
	}
}
