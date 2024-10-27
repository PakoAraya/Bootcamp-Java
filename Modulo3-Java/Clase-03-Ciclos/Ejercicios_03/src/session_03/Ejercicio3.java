package session_03;

import java.util.Scanner;

//Escribe un programa que solicite al usuario que ingrese un número positivo. Si
//el número es negativo, el programa seguirá solicitando un número positivo
//hasta que se cumpla la condición.

public class Ejercicio3 {
  public static void main(String[] args) {
    int numero;
    System.out.println("Ingrese un numero: ");
    Scanner scan = new Scanner(System.in);
    numero = scan.nextInt();

    while (numero <= 0) {
      System.out.println("Ingrese un numero positivo: ");
      numero = scan.nextInt();
    }
    System.out.println("Ha ingresado un numero positivo, salimos del While...");
  }
}