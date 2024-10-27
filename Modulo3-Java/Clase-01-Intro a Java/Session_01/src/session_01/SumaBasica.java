package session_01;

import java.util.Scanner;

public class SumaBasica {
  public static void main(String args[]) {
    // Primero definimos las variables
    int numero1, numero2, resultado;
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese el valor 1: ");
    numero1 = scan.nextInt();

    System.out.println("Ingrese el valor 2: ");
    numero2 = scan.nextInt();

    resultado = numero1 + numero2;
    System.out.println("El resultado de la suma es: " + resultado);
  }
}
