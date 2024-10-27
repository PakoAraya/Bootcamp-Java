package session_02;

import java.util.Scanner;

public class Ejercicio4 {
  public static void main(String[] args) {
    //Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    //Solicitar al usuario que ingrese el numero del 1 al 7
    System.out.println("Ingresa un numero del 1 al 7 para ver el dia de la semana: ");
    int dia = scanner.nextInt();

    //Utilizar switch-case para determinar el dia de la semana
    switch (dia) {
      case 1:
        System.out.println("Lunes");
    	break;
      case 2:
        System.out.println("Martes");
    	break;
      case 3:
        System.out.println("Miércoles");
        break;
      case 4:
        System.out.println("Jueves");
        break;
      case 5:
        System.out.println("Viernes");
        break;
      case 6:
        System.out.println("Sábado");
        break;
      case 7:
        System.out.println("Domingo");
        break;
      default:
        System.out.println("Numero no valido. Debes ingresar entre el 1 y el 7");
    	break;
    }
    //Ahora debemos cerrar el scanner
    scanner.close();
  }
}