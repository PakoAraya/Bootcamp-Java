package session_03;

import java.util.Scanner;

//Ejercicio 4: Adivinar un número
//• Instrucción: Escribe un programa que genere un número aleatorio entre 1 y
//100. Luego, el usuario debe intentar adivinar el número, y el programa debe
//darle pistas si el número ingresado es mayor o menor que el número generado.
//El ciclo debe continuar hasta que el usuario adivine el número correcto.
//• Entrada: Números ingresados por el usuario.
//• Salida: Indicaciones de si el número es mayor o menor, y mensaje al acertar.
//• TIP: while, if, entrada por consola.

public class Ejercicio4 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    //Genera un numero aleatorio entre 1 y 100.
    int numeroAleatorio = (int)(Math.random()*100+1);
    int numero = 0;
    int respUsuario = 0;

    //Mensaje al usuario
    System.out.println("Hola!!!, Intenta adivinar el numero");
    //System.out.println("Numero aleatorio: " + numeroAleatorio);
    //Aqui evaluamos que el numero ingresado no sea igual al numero aleatorio
    while(numero != numeroAleatorio) {
      System.out.println("Ingrese un numero: ");
      numero = scan.nextInt();

      if(numero > numeroAleatorio) {
        System.out.println("El numero aleatorio es menor... mala suerte Charlie...");
      }else if(numero < numeroAleatorio) {
        System.out.println("El numero aleatorio es mayor... sigue intentando Charlie...");
      }else {
        System.out.println("Felicidades Charlie!!!, Adivinaste!!!");
      }
    }
  }
}
