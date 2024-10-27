package session_02;

import java.util.Scanner;

public class Ejercicio7 {
  public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Solicitar al usuario que ingrese dos números
    System.out.print("Ingresa el primer número: ");
    int numero1 = scanner.nextInt();

    System.out.print("Ingresa el segundo número: ");
    int numero2 = scanner.nextInt();

    // Verificar si el segundo número es diferente de cero para evitar división por cero
    if (numero2 != 0) {
      // Usar if-else para determinar si el primer número es múltiplo del segundo
      if (numero1 % numero2 == 0) {
        System.out.println(numero1 + " es múltiplo de " + numero2);
      } else {
        System.out.println(numero1 + " no es múltiplo de " + numero2);
      }
    } else {
      System.out.println("Error: No se puede dividir entre cero.");
    }

    // Cerrar el scanner
    scanner.close();
  }
}
