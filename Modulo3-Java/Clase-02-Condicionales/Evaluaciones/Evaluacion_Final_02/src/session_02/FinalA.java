package session_02;

import java.util.Scanner;

//Calculo de temperatura
public class FinalA {
  public static void main(String[] args){
    double temperatura = 0;
    Scanner scan = new Scanner(System.in);
    //Solicitar la temperatura al usuario
    System.out.println("Ingrese la temperatura del dia:");
    temperatura = scan.nextDouble();

    //Determinar el tipo de clima segun la temperatura
    if(temperatura <= 10) {
      System.out.println("El clima es frio");
    }else if(temperatura > 10 && temperatura < 20) {
      System.out.println("El clima es Nublado");
    }else if (temperatura >= 20 && temperatura < 30){
      System.out.println("El clima es Caluroso");
    }else{
      System.out.println("El clima es Tropical");
    }
  }
}
