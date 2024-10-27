package session_02;

import java.util.Scanner;

public class Ejercicio3 {
  public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Solicitar al usuario que ingrese un número del 1 al 7
    System.out.print("Ingresa un número del 1 al 7 para ver el día de la semana: ");
    int dia = scanner.nextInt();

    // Utilizar switch-case para determinar el día de la semana
    switch (dia) {
      case 1:
        System.out.println("Lunes");
        break;
      case 2:
        System.out.println("Martes");
        break;
      case 3:
        System.out.println("Miércoles");
        break;
      case 4:
        System.out.println("Jueves");
        break;
      case 5:
        System.out.println("Viernes");
        break;
      case 6:
        System.out.println("Sábado");
        break;
      case 7:
        System.out.println("Domingo");
        break;
      default:
        System.out.println("Número no válido. Debe ser entre 1 y 7.");
        break;
    }

    // Cerrar el scanner
    scanner.close();
  }
}
