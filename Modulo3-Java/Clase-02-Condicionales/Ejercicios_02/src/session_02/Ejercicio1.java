package session_02;
import java.util.Scanner;

public class Ejercicio1 {
  public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Solicitar al usuario que ingrese un número
    System.out.print("Ingresa un número entero: ");
    int numero = scanner.nextInt();

    // Verificar si el número es positivo, negativo o cero
    if (numero > 0) {
      System.out.println("El número es positivo.");
    } else if (numero < 0) {
      System.out.println("El número es negativo.");
    } else {
      System.out.println("El número es cero.");
    }
    // Cerrar el scanner
    scanner.close();
  }
}
