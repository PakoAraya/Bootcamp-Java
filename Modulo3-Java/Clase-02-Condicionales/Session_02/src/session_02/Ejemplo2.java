package session_02;

import java.util.Scanner;

public class Ejemplo2 {
  public static void main(String[] args) {
    //Condicional Switch

    //Mensaje al usuario
    System.out.println("Ingrese caso: ");
    Scanner scan = new Scanner(System.in);
    int opcion = scan.nextInt();

    switch (opcion) {
      case 1:
        System.out.println("Caso 1");
    	break;
      case 2:
        System.out.println("Caso 2");
    	break;
      default:
        System.out.println("Default");
    	break;
    }
  }
}
