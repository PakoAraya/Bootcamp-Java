package session_03;

//Ejercicio 6: Números primos
//• Instrucción: Escribe un programa que solicite al usuario un número entero
//positivo N e imprima todos los números primos entre 1 y N.
//• Entrada: Un número entero positivo.
//• Salida: Todos los números primos entre 1 y N.
//• TIP: for, if, entrada por consola.
import java.util.Scanner;

public class Ejercicio6 {
  public static void main(String[] args) {
    // Crear un objeto Scanner para la entrada por consola
    Scanner scanner = new Scanner(System.in);

    // Solicitar al usuario un número entero positivo
    System.out.print("Ingrese un número entero positivo N: ");
    int N = scanner.nextInt();

    // Verificar que N sea un número entero positivo
    if (N <= 0) {
      System.out.println("Por favor, ingrese un número entero positivo.");
    } else {
      System.out.println("Números primos entre 1 y " + N + ":");
      // Recorrer todos los números del 2 al N
      for (int num = 2; num <= N; num++) {
        boolean esPrimo = true;

        // Verificar si num es primo
        for (int i = 2; i < num; i++) {
          if (num % i == 0) {
            esPrimo = false; // No es primo si es divisible por i
            break; // Salir del ciclo si encontramos un divisor
          }
        }

        // Si es primo, imprimir el número
        if (esPrimo) {
          System.out.print(num + " ");
        }
      }
    }

    // Cerrar el objeto Scanner
    scanner.close();
  }
}
