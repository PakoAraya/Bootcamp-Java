package session_01;

import java.util.Scanner;

public class Promedio {
  public static void main(String args[]) {
    //Ejercicio para calcular el promedio de numeros.
    int num1, num2, num3, promedio;
    Scanner scan = new Scanner(System.in);

    System.out.println("Ingrese el primer numero: ");
    num1 = scan.nextInt();
    System.out.println("Ingrese el segundo numero");
    num2 = scan.nextInt();
    System.out.println("Ingrese el tercer numero");
    num3 = scan.nextInt();

    promedio = (num1 + num2 + num3)/3;
    System.out.println("El promedio de los numeros es: " + promedio);
  }
}
