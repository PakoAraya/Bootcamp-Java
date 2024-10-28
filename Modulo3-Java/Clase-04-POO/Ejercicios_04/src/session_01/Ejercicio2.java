package session_01;

//Ejercicio 2: Clase Libro
//Crea una clase llamada Libro con los siguientes atributos:
//• titulo (String)
//• autor (String)
//• precio (double)
//Requisitos:
//• Crea un constructor que reciba todos los atributos.
//• Crea un constructor vacío que defina los siguientes datos : precio 500.

public class Ejercicio2 {
	public static void main(String[] args){
		//Instancia de Objeto libro
		Libro libro1 = new Libro();
		System.out.println("Instancia con constructor vacio | Precio Libro: " + libro1.precio);
		Libro libro2 = new Libro("The Lord of the Rings", "J.R.R Tolkien", 34999.90);
		System.out.println("********************************************************************************");
		System.out.println("Constructor con parametros");
		System.out.println("Nombre Libro: " + libro2.nombre + " Autor: " + libro2.autor + " Precio: " + libro2.precio);
	}
}

class Libro{
	String nombre;
	String autor;
	double precio;

	//Constructor vacio
	Libro(){
		this.precio = 500;
	}
	//Constructor con parametros
	Libro(String nombre, String autor, double precio){
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
	}
}