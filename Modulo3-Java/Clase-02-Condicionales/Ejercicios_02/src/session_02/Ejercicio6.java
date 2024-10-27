package session_02;

import java.util.Scanner;
import java.time.LocalDate;

public class Ejercicio6 {
  public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Mostrar el menú de opciones
    System.out.println("Menú de Opciones:");
    System.out.println("1. Imprimir un saludo");
    System.out.println("2. Mostrar la fecha actual");
    System.out.println("3. Salir");

    // Solicitar al usuario que seleccione una opción
    System.out.print("Selecciona una opción (1-3): ");
    int opcion = scanner.nextInt();

    // Usar switch-case para ejecutar la opción elegida
    switch (opcion) {
      case 1:
        System.out.println("¡Hola! Espero que tengas un gran día.");
        break;
      case 2:
        LocalDate fechaActual = LocalDate.now();
        System.out.println("La fecha actual es: " + fechaActual);
        break;
      case 3:
        System.out.println("Saliendo del programa...");
        break;
      default:
        System.out.println("Opción no válida. Por favor, selecciona una opción entre 1 y 3.");
        break;
    }

    // Cerrar el scanner
    scanner.close();
  }
}
