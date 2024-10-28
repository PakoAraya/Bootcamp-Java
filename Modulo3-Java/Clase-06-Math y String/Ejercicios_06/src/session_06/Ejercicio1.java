package session_06;

//Ejercicio 1: Conversor de Texto
//Descripción: Crea un programa que reciba un arreglo de cadenas de texto. El
//programa debe convertir cada cadena a mayúsculas o minúsculas según la opción
//que el usuario elija utilizando un switch y los métodos de la clase String.

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args){
		//Vamos a probar con Cadena cargada
		//String[] textos = {"Arepa","Cachapa","Platano Frito","Pastel de Choclo","Empanada"};

		//Ingrese de palabras por consola
		String[] textos = new String[5];
		Scanner scan = new Scanner(System.in);
		int opcion;

		//Ingreso de texto por consola
		System.out.println("Ingrese 5 Texto para ser convertidos a Mayusculas o Minusculas");
		for(int i=0; i<textos.length; i++){
			System.out.println("Ingrese el valor del campo " + (i+1) + ": ");
			textos[i] = scan.nextLine();
		}

		System.out.println("UPPER lower Text APP");
		System.out.println("Seleccione una opcion de ejecucion...");
		System.out.println("Opcion 1: Convertir a Mayusculas");
		System.out.println("Opcion 2: Convertir a Minusculas");
		opcion = scan.nextInt();

		//Desarrollo de las opciones solicitadas
		switch(opcion){
		case 1:
			for (int i=0; i< textos.length; i++){
				textos[i] = textos[i].toUpperCase();
			}
			break;
		case 2:
			for(int i=0; i<textos.length; i++){
				textos[i] = textos[i].toLowerCase();
			}
			break;
		default:
			System.out.println("Opcion no valida. No se realizara ninguna accion");
		}
		//Impresion del arreglo modificado, lo haremos con foreach
		for(String texto : textos){
			System.out.println(texto);
		}
	}
}
