package session_14;

//Hoy veremos el manejo de excepciones
public class Ejemplo1 {
	public static void main(String[] args) {

		//Ejemplo de manejo de excepciones aritmeticos
		int a = 10;
		int b = 0;

		try {
			int resultado = a / b; // No lanza ArithmeticException
			System.out.println("Resultado: " + resultado); // Imprime 'Infinity'
		} catch (ArithmeticException e) {
			System.out.println("Error: División por cero.");
		}
	}
}
