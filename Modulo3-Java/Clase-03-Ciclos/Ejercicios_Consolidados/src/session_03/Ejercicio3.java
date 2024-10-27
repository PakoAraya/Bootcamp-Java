package session_03;

import java.util.Scanner;

//Ejercicio 3: Suma de los primeros N números
//• Instrucción: Escribe un programa que solicite al usuario un número entero
//positivo N e imprima la suma de los primeros N números (1 + 2 + 3 + ... + N).
//• Entrada: Un número entero positivo.
//• Salida: La suma de los primeros N números.
//• TIP: for, entrada por consola.

public class Ejercicio3 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    //Solicitar al usuario que ingrese un numero
    System.out.println("Ingrese un numero positivo: ");
    int numero = scan.nextInt();
    //Validar que numero sea positivo o negativo
    if(numero >= 0) {
      //Variable que almacenara los numeros sumados
      int suma = 0;
      //Recorrer en ciclo hasta el numero ingresado.
      for(int i=1; i<=numero ; i++) {
        suma += i;
      }
      System.out.println("La suma de los numeros es: " + suma);
    }else {
      System.out.println("Debe ingresar un numero positivo...");
    }
  }
}