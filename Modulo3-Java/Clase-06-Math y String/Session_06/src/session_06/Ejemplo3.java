package session_06;

public class Ejemplo3 {
	public static void main(String[] args){
		//Repaso de la clase String
		String texto = "Bootcamp";
		System.out.println("Largo del texto: " + texto.length());
		//Equals es boolean, o sea devuelve true o false.
		System.out.println("Valor".equals("Valor")); //Devuelve true.
		//Trim es para cortar cadenas de texto
		System.out.print("Valor Trim " + texto.trim());
		System.out.println(".");
		//Texto con substring
		System.out.println("Valor Substring: " + texto.substring(0,4));
		//Tambien se puede concatener texto
		System.out.println("Valor concatenado: " + texto.concat(" en Java Java Duuuu!!!"));
		//Tambien se puede usar el reemplazo, replace
		System.out.println("Valor Replace " + texto.replace("o", "A"));
	}
}
