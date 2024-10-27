package session_03;

import java.util.Scanner;

//Crea un programa que genere un menú sencillo con 3 opciones:
//1. Sumar dos números. 2.Restar dos números. 3.Salir.
//El programa deberá repetirse hasta que el usuario elija la opción de salir.
public class Ejercicio4 {
  public static void main(String[] args) {


    int opcion;
    Scanner scan = new Scanner(System.in);

    do {
      System.out.println("Chanta-App");
      System.out.println("Ingrese algunas de las opciones");
      System.out.println("1. Sumar dos números.");
      System.out.println("2. Restar dos números.");
      System.out.println("3. Salir.");
      opcion = scan.nextInt();

    } while (opcion != 3);
    System.out.println("Saliendo del programa");
  }
}