package session_14;

public class Ejemplo4 {
	public static void main(String[] args) {
		int numerador = 10;
		int denominador = 0;
		int resultado = 0;

		try {
			// Intentamos dividir los números
			resultado = numerador / denominador;
			System.out.println("Resultado: " + resultado);
		} catch (ArithmeticException e) {
			// Se captura la excepción de división por cero
			System.out.println("Error: No se puede dividir por cero!");
		} finally {
			// El bloque finally siempre se ejecuta
			System.out.println("Ejecución finalizada, Limpiando...");
		}
	}
}
