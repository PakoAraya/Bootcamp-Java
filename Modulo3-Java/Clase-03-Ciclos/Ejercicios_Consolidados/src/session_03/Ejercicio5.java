package session_03;

import java.util.Scanner;

//Ejercicio 5: Calcular el promedio de N notas
//• Instrucción: Escribe un programa que permita ingresar N notas de un
//estudiante (N es ingresado por el usuario) y luego calcule el promedio de esas
//notas. El ciclo debe continuar mientras el número de notas ingresado sea
//mayor que 0.
//• Entrada: Notas ingresadas por el usuario.
//• Salida: El promedio de las notas.
//• TIP: while, entrada por consola.

public class Ejercicio5 {
  public static void main(String[] args) {

    //Creacion del Scanner
    Scanner scan = new Scanner(System.in);
    //Variable que trabajaremos en la aplicacion
    int cantNotas = 0;
    int contador = 1;
    double suma = 0;
    double promedio = 0;
    double nota=0;
    //double es para decimales

    //Solicitar al usuario la cantidad de notas a ingresar
    System.out.println("Ingrese el numero de notas (mayor que 0)");
    cantNotas = scan.nextInt();

    //Verificar que la cantidad de notas sea mayor a cero
    if(cantNotas <=0) {
      System.out.println("El numero de notas tiene que ser mayor que cero");
    }else {
      //Aqui vamos a contar las notas y sacar promedio
      while(contador <= cantNotas) {
        System.out.println("Ingrese la nota " + contador + " : ");
        nota = scan.nextDouble();
        //suma = suma + nota;
        suma += nota;
        contador++;
      }
      //Aqui se calcula el promedio
      promedio = suma / cantNotas;
      System.out.println("El promedio de notas es: " + promedio);
    }
  }
}