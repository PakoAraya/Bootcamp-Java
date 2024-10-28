package session_06;

public class Ejemplo1 {
	public static void main(String[] args){
		int[] array = new int[5];

		//largo
		System.out.println("Largo del array: " + array.length);
		//Primera posicion
		System.out.println("Primer dato del array: " + array[0]);
		//Ultima posicion
		System.out.println("Ultima posicion: " + array[array.length-1]);

		//Ejemplo de Equals
		String[] array2 = {"Hola", "Mundo"};
		//Equals compara 2 objetos String
		if (array2[0].equals(array2[array2.length-1])){
			System.out.println("Datos iguales en Array2");
		}else{
			System.out.println("No es igual");
		}

		//Matrices
		int[][] matriz1 = new int[2][2];
		//[3][7]
		//[4][5]

		//Tras recorrerse la matriz con FOR nos da
		//For para i | i=0 => [3][7]  |  i=1 => [4][5]
		//For para j | j=0 => [3] | j=1 = [7] || j=0 = [4] | j=1 = [5] |
		System.out.println("*****************************");
		System.out.println("Impresion diagonal de la matriz");
		int[][] matriz = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};

		for (int i = 0; i < matriz.length; i++) {
			System.out.println(matriz[i][i]);
		}
	}
}
