package session_01;

import java.util.Scanner;

public class Fahrenheit {
  public static void main(String args[]) {
    //Calcular de Celsius a Fahrenheit
    int tempC = 0, temperatura = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese la temperatura en Celsius: ");
    tempC = scan.nextInt();
    //Se aplica casting para transformar el decimal a entero.
    temperatura = (int)((tempC * 1.8) +32);

    System.out.println("La temperatura ingresada es: " + tempC + " Celsius");
    System.out.println("Y la temperatura en Fahrenheit es: " + temperatura + " Fahrenheit");
  }
}
