package session_01;
//Para esta actividad usted deberá solicitar el peso (en kilogramos) y la altura (en metros).
//Después de eso deberá́calcular el IMC (Índice de Masa Muscular) de la persona que ingreso el
//dato (IMC = kg / mts2). La salida del programa será:
import java.util.Scanner;
public class Drill1B {
public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);

  // Solicitar peso y altura
  System.out.print("Ingrese su peso en kilogramos: ");
  double peso = scanner.nextDouble();

  System.out.print("Ingrese su altura en metros: ");
  double altura = scanner.nextDouble();

  // Calcular IMC
  double imc = peso / (altura * altura);

  // Mostrar resultado
  System.out.printf("Su IMC es: %.2f%n", imc);

  scanner.close();
  }
}