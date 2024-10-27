package session_03;

import java.util.Scanner;

public class FinalA {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int contadorPares = 0, contadorImpares=0, numero;

    while(true){
      System.out.println("Ingrese una número entre 1 al 100: ");
      numero = scan.nextInt();
      if (numero <1 || numero > 100) {
        System.out.println("--- ERROR ---");
        System.out.println("Ingrese un numero del 1 al 100");
      }else {
        //Salir del bucle si es valido
        break;
      }
    }

    //Evaluar si es par o impar y contar
    for (int i = 1; i <= numero; i++) {
      if (i % 2 == 0) {
        contadorPares++;
      }else {
        contadorImpares++;
      }
    }

    //Mostrar los resultados
    System.out.println("El total de numeros pares es: " + contadorPares);
    System.out.println("El total de numeros impares es: " + contadorImpares);
  }
}
