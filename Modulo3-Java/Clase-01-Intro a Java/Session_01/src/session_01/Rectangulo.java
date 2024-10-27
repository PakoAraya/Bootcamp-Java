package session_01;

import java.util.Scanner;

public class Rectangulo {
  public static void main(String args[]) {
    //Ejercicio que le pide al usuario ingresar largo y ancho para el calculo.
    int altura, ancho, area;
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese la altura del triangulo");
    altura = scan.nextInt();
    System.out.println("Ingrese el ancho del triangulo");
    ancho = scan.nextInt();

    area = altura* ancho;
    System.out.println("El areal del rectangulo es: " + area);
  }
}
