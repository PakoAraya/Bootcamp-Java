package session_02.ejercicio3;
/*
Ejercicio 3: Eliminar un Elemento del ArrayList
Descripción: Crea un programa que permita al usuario eliminar un nombre
específico de la lista de nombres ingresados.
TIP: remove(objeto a buscar | posición) tambien puede usarse para búsqueda y
eliminación ( investigar).
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		//Vamos a crear el Arraylist para ingresar nombres
		ArrayList<String> nombresList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String nombre;
		String preguntaContinuar;
		String buscarNombre;
		String nombreEliminar;

		//Crear ciclo para ingresar nombres
		System.out.println("******* APP para quitar nombres ******");
		do{
			System.out.println("Ingrese el nombre del usuario: ");
			nombre = scan.nextLine().toLowerCase();
			nombresList.add(nombre);

			//Preguntar si se quiere ingresar mas usuarios
			System.out.println("Desea ingresar mas usuarios??? (si/no): ");
			preguntaContinuar = scan.nextLine().toLowerCase();
		}while(preguntaContinuar.equals("si"));

		//Mostremos el listado de estudiantes (Foreach)
		System.out.println("\nLos nombres de los usuarios ingresados son: ");
		for(String nombre_usuario : nombresList){
			System.out.println(nombre_usuario);
		}

		//Solicitar que ingrese el nombre del usuario a eliminar
		System.out.println("\n Ingrese el nombre del usuario que quieres eliminar: ");
		nombreEliminar = scan.nextLine().toLowerCase();
		boolean eliminado = false;
		for (int i=0; i< nombresList.size(); i++) {
			if (nombresList.get(i).contains(nombreEliminar)) {
				nombresList.remove(i);
				eliminado = true;
				break;
			}
		}

		//Mostrar el resultado de la eliminacion
		if(eliminado){
			System.out.println("\n" + nombreEliminar + " ha sido eliminado...");
		}else {
			System.out.println("\n" + nombreEliminar + " no ha sido eliminado...");
		}

		//Mostremos el listado de estudiantes (Foreach)
		System.out.println("\nLos nombres de los usuarios ingresados son: ");
		for(String nombre_usuario : nombresList){
			System.out.println(nombre_usuario);
		}
	}
}
