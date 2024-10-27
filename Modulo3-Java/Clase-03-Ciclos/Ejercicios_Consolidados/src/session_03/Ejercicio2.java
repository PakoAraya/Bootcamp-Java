package session_03;

import java.util.Scanner;

//Ejercicio 2: Contador de números positivos, negativos y ceros
//• Instrucción: Crea un programa que permita al usuario ingresar 10 números
//enteros. Luego, el programa debe contar cuántos de esos números son
//positivos, cuántos son negativos y cuántos son ceros.
//• Entrada: 10 números enteros.
//• Salida: Cantidad de números positivos, negativos y ceros.
//• TIP: for, if, entrada por consola.

public class Ejercicio2 {
  public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    int numero = 0;

    //variables
    int positivos = 0;
    int negativos = 0;
    int ceros = 0;

    //Creamos ciclo para ingresar 10 numeros
    System.out.println("Ingrese un numero:");
    for(int i = 1; i<= 10; i++) {
      System.out.println("Ingrese Numero " + i + " : ");
      numero = scan.nextInt();

      //Verificamos si numero es positivo, negativo o cero
      if(numero > 0) {
        positivos++; //Sumamos los positivos
      }else if(numero < 0) {
        negativos++; //Sumamos los negativos
      }else {
        ceros++; //Sumamos los ceros
      }
    }
    //Imprimimos los valores.
    System.out.println("Resultados:");
    System.out.println("Los numeros positivos son: " + positivos);
    System.out.println("Los numeros negativos son: " + negativos);
    System.out.println("La cantidad de ceros es: " + ceros);
  }
}