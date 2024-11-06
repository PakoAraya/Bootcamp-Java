package session_14;

public class CalculadoraDivisiones {

	public static void dividir(int[] numeradores, int[] denominadores) {
		for (int i = 0; i < numeradores.length; i++) {
			try {
				// Intenta dividir el elemento en numeradores por el elemento en denominadores
				int resultado = numeradores[i] / denominadores[i];
				System.out.println("Resultado de " + numeradores[i] + " / " + denominadores[i] + " es: " + resultado);
			} catch (ArithmeticException e) {
				// Manejo de división por cero
				System.out.println("Error: División por cero en la posición " + i);
			} catch (ArrayIndexOutOfBoundsException e) {
				// Manejo de acceso fuera de los límites del arreglo
				System.out.println("Error: No hay un denominador para el numerador en la posición " + i);
				break; // Finaliza el bucle si no hay más denominadores
			} finally {
				System.out.println("Operación completada para el índice " + i);
			}
		}
	}

	public static void main(String[] args) {
		int[] numeradores = {4, 8, 16, 32, 64, 128, 256, 512};
		int[] denominadores = {2, 0, 4, 4, 0, 8}; // Menos elementos que numeradores para probar fuera de límites

		try {
			dividir(numeradores, denominadores);
		} catch (Exception e) {
			System.out.println("Excepción en el método main: " + e.getMessage());
		}
	}
}