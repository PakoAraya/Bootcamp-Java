package session_02;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Solicitar al usuario que ingrese una calificación entre 0 y 100
    System.out.print("Ingresa una calificación entre 0 y 100: ");
    int calificacion = scanner.nextInt();

    // Verificar y clasificar la calificación
    if (calificacion >= 90 && calificacion <= 100) {
      System.out.println("Calificación: A");
    } else if (calificacion >= 80 && calificacion <= 89) {
      System.out.println("Calificación: B");
    } else if (calificacion >= 70 && calificacion <= 79) {
      System.out.println("Calificación: C");
    } else if (calificacion >= 60 && calificacion <= 69) {
      System.out.println("Calificación: D");
    } else if (calificacion >= 0 && calificacion <= 59) {
      System.out.println("Calificación: F");
    } else {
      System.out.println("Calificación no válida. Debe estar entre 0 y 100.");
    }

    // Cerrar el scanner
    scanner.close();
  }
}
