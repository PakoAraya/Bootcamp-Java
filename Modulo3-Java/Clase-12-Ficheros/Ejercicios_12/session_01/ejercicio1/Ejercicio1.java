package session_01.ejercicio1;

//Ejercicio 1: Leer Nombres y Guardarlos en un ArrayList
//• Descripción: Crea un archivo de texto llamado nombres.txt que contenga
//nombres de personas, uno en cada línea. El programa debe leer estos
//nombres, almacenarlos en un ArrayList<String> y mostrar la lista completa en
//la consola.
//• Instrucciones:
//1. Escribe un programa en Java que:
//▪ Lea cada nombre del archivo.
//▪ Almacene cada nombre en un ArrayList<String>.
//▪ Imprima en consola todos los nombres almacenados.
//• Investigación: Investiga el metodo split() en Java, el cual se utilizará en
//próximos ejercicios para dividir y procesar datos de una línea de texto.
//
//Camejo
//Salas
//Vera
//Honores

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio1 {
	public static void main(String[] args) {
		String nombreArchivo = "/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-12-Ficheros/Session_12/src/session_01/ejercicio1/nombres.txt";
		ArrayList<String> nombres = new ArrayList<>();

		try{
			FileReader fr = new FileReader(nombreArchivo);  //Accede al archivo y como que lo transforma en objeto
			BufferedReader br = new BufferedReader(fr);     //Lee linea por linea el archivo.

			String linea;
			while ((linea = br.readLine()) != null){
				nombres.add(linea);
			}

		} catch (IOException e) {
			//throw new RuntimeException(e);
			System.out.println("Ocurrio un error al leer el archivo: " + e.getMessage());
		}

		//Mostrar los elementos almacenados en el Arraylist
		System.out.println("Nombres leidos del archivo: ");
		for(String nombre: nombres){
			System.out.println(nombre);
		}
	}
}

