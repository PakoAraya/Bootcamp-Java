package session_02;

import java.util.Scanner;

public class CalculoPago {
  public static void main(String[] args) {
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Solicitar el nombre del usuario
    System.out.print("Ingresa tu nombre: ");
    String nombre = scanner.nextLine();

    // Solicitar los 5 valores de la lista de compras
    double totalCompra = 0;
    for (int i = 1; i <= 5; i++) {
      System.out.print("Ingresa el valor de la compra " + i + ": ");
      double valor = scanner.nextDouble();
      totalCompra += valor;
    }

    // Mostrar el total de la compra
    System.out.println("Total de la compra: $" + totalCompra);

    // Determinar el método de pago usando sentencias condicionales
    if (totalCompra <= 10000) {
      System.out.println(nombre + ", el pago será en efectivo.");
    } else if (totalCompra <= 20000) {
      System.out.println(nombre + ", el pago será con tarjeta.");
    } else {
      System.out.println(nombre + ", el pago será con cheque.");
    }

    // Cerrar el scanner
    scanner.close();
  }
}
