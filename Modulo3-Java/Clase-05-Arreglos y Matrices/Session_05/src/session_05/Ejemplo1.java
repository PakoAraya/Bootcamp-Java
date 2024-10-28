package session_05;

//Hoy veremos arreglos
public class Ejemplo1 {
	public static void main(String[] args) {
		//Declaracion de un arreglo
		int[] arreglo = new int[3];
		arreglo[0] = 3;
		arreglo[1] = 2;
		arreglo[2] = 1;
		//Vamos a imprimir el arreglo completo
		for(int i=0; i < arreglo.length; i++) {
			System.out.println("Elemento en el indice " + i + ": " + arreglo[i]);
		}
		//O podemos indicar que queremos indicar una posicion especifica
		System.out.println("Elemento: " + arreglo[0]);

		System.out.println("-----------------------------------------");
		System.out.println("Impresion con foreach");
		//Ahora evaluaremos un foreach
		for (int elemento : arreglo) {
			System.out.println("Elemento: " + elemento);
		}
	}
}

