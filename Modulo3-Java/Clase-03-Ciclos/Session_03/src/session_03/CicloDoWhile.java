package session_03;

public class CicloDoWhile {
  public static void main(String[] args) {
    int numero = 0;
    //Primero ejecuta y luego pregunta
    do{
      System.out.println("Número: " + numero);
      numero++;
    }while(numero < 5);
    System.out.println("Sali del Do-While...");
  }
}
