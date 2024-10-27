package session_01;

import java.util.Scanner;

public class Operaciones {
  public static void main(String args[]) {
    //Vamos a hacer operaciones basicas con Java
    int numero1, numero2;
    int resulSum = 0;
    int resulRes = 0;
    int resulMul = 0;
    int resultDiv = 0;
    System.out.println("Ingresaremos 2 numeros y haremos operaciones basicas con ellos");
    System.out.println("Ingresa el primer numero");
    //Creando el Scanner
    Scanner scan = new Scanner(System.in);
    numero1 = scan.nextInt();
    System.out.println("Ingresa el segundo numero");
    numero2 = scan.nextInt();

    resulSum = numero1 + numero2;
    resulRes = numero1 - numero2;
    resulMul = numero1 * numero2;
    resultDiv = numero1 / numero2;

    System.out.println("El resultado de la suma es: " + resulSum);
    System.out.println("El resultado de la resta es: " + resulRes);
    System.out.println("El resultado de la multiplicacion es: " + resulMul);
    System.out.println("El resultado de la division es: " + resultDiv);
  }
}
