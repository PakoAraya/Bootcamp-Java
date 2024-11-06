package session_02;

import java.util.ArrayList;

public class Ejemplo {
	public static void main(String[] args) {
		ArrayList<String> nombresList = new ArrayList<>();
		//Vamos a agregar cosas al arraylist
		nombresList.add("Felix");
		nombresList.add("Esilda");
		nombresList.add("Jacky");

		//Para comprobarlo vamos a imprimir
		System.out.println(nombresList);

		//Metodo get para acceder a una posicion en especifico
		System.out.println(nombresList.get(2));

		//Metodo set nos permite modificar elementos del arraylist
		nombresList.set(1, "PaKo");
		System.out.println(nombresList);
		System.out.println(nombresList.size()); //Para ver el tamaño del arraylist

		//Metodo Remove que quita elementos
		nombresList.remove(0);
		System.out.println(nombresList);

		//Metodo size nos permite ver el tamaño del arraylist
		System.out.println(nombresList.size());

		//Para recorrer el arraylist lo hacemos con un foreach
		// Tipo de dato (String) |  Nombre variable (nombre) | Arraylist a recorrer (nombres)
		for(String nombre:nombresList){
			System.out.println("Nombre: " + nombre);
		}

		//Para limpiar el arraylist se usa el clear
		nombresList.clear();
		System.out.println(nombresList);

		//El metodo isEmpty nos muestra que el arraylist esta vacio
		System.out.println("La lista esta vacia?: " + nombresList.isEmpty());

	}
}
