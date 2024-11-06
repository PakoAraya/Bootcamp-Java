package session_14;

public class Ejemplo2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;

		try {
			if (b == 0) {
				throw new ArithmeticException("No se puede dividir por cero."); // Lanzar manualmente
			}
			int resultado = a / b; // Nunca se ejecutará si b es 0
			System.out.println("Resultado: " + resultado);
		} catch (ArithmeticException e) {
			System.out.println("Error personalizado: " + e.getMessage()); // Imprime el mensaje personalizado
		}
	}
}
