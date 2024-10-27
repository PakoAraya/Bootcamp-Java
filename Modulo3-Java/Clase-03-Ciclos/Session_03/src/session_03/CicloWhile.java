package session_03;

import java.util.Scanner;

public class CicloWhile {
  public static void main(String[] args) {
    int numero = 0;
    Scanner sc = new Scanner(System.in);

    //Primero pregunta, luego ejecuta
    while(numero == 0){
      System.out.println("Ingrese el primer número: ");
      numero = sc.nextInt();
    }
    System.out.println("While");
  }
}
