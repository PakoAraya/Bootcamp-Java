package session_02;

import java.util.Scanner;

public class FinalB {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    double saldo = 1000;  // Saldo inicial
    int opcion;

    do {
      // Mostrar el menú
      System.out.println("\nBienvenido al Cajero Automático");
      System.out.println("1. Depositar dinero");
      System.out.println("2. Retirar dinero");
      System.out.println("3. Salir");
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1: // Opción para depositar dinero
          System.out.print("Ingrese la cantidad a depositar: ");
          double deposito = scanner.nextDouble();
          saldo += deposito;
          System.out.println("Depósito exitoso. Su nuevo saldo es: $" + saldo);
          break;

        case 2: // Opción para retirar dinero
          System.out.print("Ingrese la cantidad a retirar: ");
          double retiro = scanner.nextDouble();
          if (retiro <= saldo) {
            saldo -= retiro;
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
          } else {
            System.out.println("Saldo insuficiente.");
          }
          break;

        case 3: // Opción para salir
          System.out.println("Gracias por utilizar el cajero automático. ¡Hasta luego!");
          break;

        default: // Opción no válida
          System.out.println("Opción no válida. Intente de nuevo.");
      }
    } while (opcion != 3); // El programa se repetirá hasta que se seleccione la opción "Salir"
  }
}