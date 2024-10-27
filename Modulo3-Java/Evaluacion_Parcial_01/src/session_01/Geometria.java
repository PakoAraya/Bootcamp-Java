package session_01;

import java.util.Scanner;

public class Geometria {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int base, altura, area, perimetro;

    System.out.println("App para calcular area y perimetro de rectagulo");
    System.out.println("Ingrese la base del rectangulo: ");
    base = scan.nextInt();
    System.out.println("Ingrese la altura del rectangulo: ");
    altura = scan.nextInt();

    area = base * altura;
    perimetro = (base * 2) + (altura * 2);

    System.out.println("El Area del rectangulo es: " + area);
    System.out.println("El perimetro del rectangulo es: " + perimetro);
  }
}
