package session_03;

public class OperadoresAsignacion {
  public static void main(String[] args) {
    //Breve repaso de operadores de asignacion
	  int numero = 10;

    System.out.println("Número: " + numero);
    //numero = numero + 10;
    numero += 10;
    System.out.println("Número suma: " + numero);

    //numero = numero *5;
    numero *= 5;
    System.out.println("Número mult: " + numero);

    //++ o --
    numero++;
    System.out.println("Número ++: "  +numero);

    numero--;
    System.out.println("Número --: "  +numero);

    //Tambien funciona con los simbolos antes
    ++numero;
    System.out.println("++Número: "  +numero);
  }
}
