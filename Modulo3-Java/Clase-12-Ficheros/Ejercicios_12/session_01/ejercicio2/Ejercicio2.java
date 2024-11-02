package session_01.ejercicio2;

//Ejercicio 2: Leer Frases y Contar Palabras en Cada Frase
//• Descripción: Crea un archivo de texto llamado frases.txt con varias frases,
//cada una en una línea. El programa debe leer cada frase, almacenarla en un
//ArrayList<String>, y luego contar el número de palabras en cada frase.
//• Instrucciones:
//1. Escribe un programa en Java que:
//▪ Lea cada frase y la almacene en un ArrayList<String>.
//▪ Utilice el metodo split() para contar las palabras en cada frase.
//▪ Imprima cada frase junto con el número de palabras que contiene.
//• Investigación: Investiga cómo funciona el metodo split("\\s+") en Java para
//dividir una cadena de texto en palabras usando espacios en blanco como
//separador.
//La programación es divertida.
//Java es un lenguaje de propósito general.
//¡Practicar ayuda a mejorar!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio2 {
	public static void main(String[] args) {
		String rutaArchivo = "/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-12-Ficheros/Session_12/src/session_01/ejercicio2/frases.txt";
		ArrayList<String> frases = new ArrayList<>();

		try{
			FileReader fr = new FileReader(rutaArchivo);
			BufferedReader br = new BufferedReader(fr);

			String frase;
			while((frase = br.readLine()) != null){
				frases.add(frase);
			}
		} catch (IOException e) {
			//throw new RuntimeException(e);
			System.out.println("Ocurrio un error al intentar abrir el archivo...");
		}

		//Imprimir el contenido del Arraylist
		System.out.println("Las Frases y las cantidades de palabras son: ");
		for(String frase:frases){
			//Aqui hay que aplicar el String
			String[] palabras = frase.split("\\s+"); //Hola a todos 3 => Array.length
			int cantidadPalabras = palabras.length;

			//Imprimir los resultados
			System.out.println("La frase: " + frase + " contiene: " + cantidadPalabras + " palabras...");
			//Otra forma de imprimir mas profesionalmente
			//System.out.println("La frase: " + frase + " contiene: " + frase.split("\\s+").length + " palabras...");
		}
	}
}


