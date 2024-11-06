package session_14;

public class Ejemplo3 {
	//Usando throws y throw
	public static void main(String[] args) throws ArithmeticException {

		int a = 10;
		int b = 0;

		try {
			if (b == 0) {
				// Lanzar manualmente la excepción si el divisor es 0
				throw new ArithmeticException("División por cero no permitida.");
			}
			int resultado = a / b; // Esta línea no se ejecutará si b es 0
			System.out.println("Resultado: " + resultado);
		} catch (ArithmeticException e) {
			// Manejar la excepción y mostrar un mensaje adecuado
			System.out.println("Error capturado: " + e.getMessage());
		}

		// Código adicional que seguirá ejecutándose a pesar de la excepción
		System.out.println("El programa continúa ejecutándose.");
	}
}
