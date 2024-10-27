package session_02;

public class Ejemplo1 {
  public static void main(String[] args) {
    //Condicional if
	  int numero1, numero2;

    numero1 = 1;
    numero2 = 2;

    //and 'Y' &&  true si ambos son verdaderos  1 | 1 = 1
    //or  'o' ||  true si uno es verdad         1 | 0 = 1

    if(numero1>0 || numero2>0){
      //Bloque true
      System.out.println("");
    } else if (numero1 < numero2) {
      System.out.println("asi no si");
    }else{
      //si no
      System.out.println("si no");
    }
  }
}
