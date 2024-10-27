package session_01;

import java.util.Scanner;

public class ParImpar {
  public static void main(String args[]) {
    //Averiguar si el numero es par o impar
    int numero=0;
    Scanner scan = new Scanner(System.in);
    System.out.println("App que determina si numero es Par o Impar");
    System.out.println("Ingrese el numero: ");
    numero = scan.nextInt();
    if(numero%2 == 0) {
      System.out.println("El numero es par");
    }else {
      System.out.println("El numero es impar");
    }
  }
}
