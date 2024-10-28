package session_05;

//Ejemplo 2 Matrices que son arreglos bidimensionales
public class Ejemplo2 {
	public static void main(String[] args) {
		//Declaracion de la matriz
		int[][] matriz = new int[3][3];

		//llenamos la matriz
		//Primero va columna y despues fila
		matriz[0][0]=56; matriz[0][1]=5; matriz[0][2]=5;
		matriz[1][0]=43; matriz[1][1]=7; matriz[1][2]=3;
		matriz[2][0]=23; matriz[2][1]=9; matriz[2][2]=1;

		//Para imprimir
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println("Elemento en [i " + i + "][j " + j +"] = " + matriz[i][j]);
			}
		}

		//Otra forma de hacerlo
		//	for (int i = 0; i < matriz.length; i++) {  // indice i i=0            i=1 
		//   for (int j = 0; j < matriz[i].length; j++) { //indice    j j=0, j=1       j=0 j=1 
		//       System.out.println("Elemento en [i " + i + "][j " + j + "] = " + matriz[i][j]);          
		//   }
		//	}

	}
}