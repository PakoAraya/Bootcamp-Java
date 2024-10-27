package session_02;

import java.util.Scanner;

public class Ejercicio2 {
  public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Solicitar al usuario que ingrese su edad
    System.out.print("Ingresa tu edad: ");
    int edad = scanner.nextInt();

    // Clasificar la edad en una de las categorías
    if (edad >= 0 && edad <= 12) {
      System.out.println("Niño");
    } else if (edad >= 13 && edad <= 17) {
      System.out.println("Adolescente");
    } else if (edad >= 18 && edad <= 64) {
      System.out.println("Adulto");
    } else if (edad >= 65) {
      System.out.println("Adulto mayor");
    } else {
      System.out.println("Edad no válida");
    }
    // Cerrar el scanner
    scanner.close();
  }
}
