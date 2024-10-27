package session_03;

import java.util.Scanner;

public class FinalB {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int contadorPositivos = 0, contadorNegativos = 0, contadorCeros = 0, numero;

    System.out.println("Ingrese 10 numeros para determinar a cada numero...");
    for (int i = 1; i <= 10; i++) {
      System.out.println("Ingrese el numero: " + i);
      numero = scan.nextInt();
      //Evaluar el tipo de numero
      if(numero > 0) {
        contadorPositivos++;
      }else if(numero <0) {
        contadorNegativos++;
      }else {
        contadorCeros++;
      }
    }
    //Mostrar los datos por consola
    System.out.println("El total de numeros positivos es: " + contadorPositivos);
    System.out.println("El total de numeros negativos es: " + contadorNegativos);
    System.out.println("El total de ceros es: " + contadorCeros);
  }
}
