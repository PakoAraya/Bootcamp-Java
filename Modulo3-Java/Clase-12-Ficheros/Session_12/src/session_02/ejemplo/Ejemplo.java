package session_02.ejemplo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import session_02.ejemplo.Personas;

public class Ejemplo {

	public static  String nombreArchivo="/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-12-Ficheros/Session_12/src/session_02/ejemplo/numeros.txt";

	public static void main(String[] args) {
		System.out.println("lectura y escritura de personas: ");

		Scanner scanner = new Scanner(System.in);


		for(int i=0;i<2;i++ ) {
			System.out.print("Ingrese la edad de la persona: ");
			int edad = scanner.nextInt();

			scanner.nextLine();
			System.out.print("Ingrese el nombre de la persona: ");
			String nombre = scanner.nextLine();

			Personas persona= new Personas(nombre, edad);
			System.out.println(persona.toString());


			guardar(persona);
		}


		ArrayList<Personas> personas= lectura();
		for(Personas persona:personas) {
			System.out.println("nombre: " +persona.getNombre() +" edad "+persona.getEdad() );
		}

		System.out.println("Fin");
	}


	public static <T> void guardar(T valor) {
		try (FileWriter fw= new FileWriter(nombreArchivo,true);
				PrintWriter pw= new PrintWriter(fw);){
			pw.println(valor.toString());
		}catch(IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}


	public static ArrayList<Personas> lectura(){

		ArrayList<Personas> numeros= new ArrayList<>();
		try {
			FileReader fr= new FileReader(nombreArchivo);
			BufferedReader br= new BufferedReader(fr);

			String linea;

			while((linea=br.readLine())!=null) {
				//catalina,12 .split(",")

				String[] partes= linea.trim().split(",");
				//[catalina][12]

				Personas persona= new Personas(partes[0], Integer.parseInt(partes[1]));
				numeros.add(persona);
			}


		}catch(IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());

		}
		return numeros;
	}

}