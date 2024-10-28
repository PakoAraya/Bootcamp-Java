package session_06;

public class Ejemplo2 {
	public static void main(String[] args) {
		//Revision de la clase Maths
		int valor1=-8;
		int valor2=4;

		System.out.println("Valor absoluto: " + Math.abs(valor1));
		//Este codigo tiene problemas, no puede sacar la raiz de numeros negativo, primero hay que pasarlo a absoluto
		//System.out.println("Valor raiz cuadrada: " + Math.sqrt(valor1));
		System.out.println("Valor raiz cuadrada: " + Math.sqrt(Math.abs(valor1)));

		//Vamos a trabajar con potencias (POW)
		System.out.println("El valor con potencia es: " + Math.pow(valor2, valor1));

		//Para numeros Random
		System.out.println("Valor Random: " + Math.random());
	}
}
