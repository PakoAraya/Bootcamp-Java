package session_03;
//Escribe un programa que imprima una tabla de multiplicar del 1 al 10. La tabla
//debe tener el siguiente formato:
public class Ejercicio5 {
  public static void main(String[] args) {

    for (int i = 0; i<=10; i++) {
      for(int j=0; j<=10; j++) {
        System.out.println("Multiplo de " + i + " X " + j + " = " + i*j);
      }
    }
  }
}