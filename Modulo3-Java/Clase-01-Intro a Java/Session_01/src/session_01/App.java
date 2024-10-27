package session_01;

import java.util.Scanner;

//Estamos desarrollando
/*
 * Estamos desarrollando en Java
 * 
 */
public class App {
  public static void main(String[] args) {
  	System.out.println("Java Java Duuuu!!!");
	System.out.println("Hola Mundo!!!");
	  
	Scanner sc = new Scanner(System.in);
	System.out.println("Ingrese un numero: ");

	//Vamos a declarar una variable de tipo numero.
	int numero;
	numero = sc.nextInt();
	System.out.println("Mi numero es: " + numero);
  }
}
