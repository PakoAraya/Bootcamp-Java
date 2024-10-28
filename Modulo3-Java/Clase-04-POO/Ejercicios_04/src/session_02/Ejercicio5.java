package session_02;

//Ejercicio 5:
//o Crea una clase Cliente con los atributos nombre y direccion.
//o Sobrecarga el método toString() para mostrar la información del cliente.

public class Ejercicio5 {
	public static void  main(String[] args){
		//Creacion de objetos
		Cliente cliente1 = new Cliente("John Connor","Av. Skynet #54321");
		Cliente cliente2 = new Cliente("Homero J. Simpson", "Av. Siempre Viva #742");

		//Impresion de los datos
		System.out.println("Datos cliente 1: " + cliente1);
		System.out.println("Datos cliente 2: " + cliente2);
	}
}

//Clase Cliente
class Cliente{
	//Atributos
	String nombre;
	String direccion;

	//Constructor
	Cliente (String nombre, String direccion){
		this.nombre = nombre;
		this.direccion = direccion;
	}

	//Metodo toString
	public String toString(){
		return "Cliente: " + nombre + ", direccion: " + direccion;
	}

}
