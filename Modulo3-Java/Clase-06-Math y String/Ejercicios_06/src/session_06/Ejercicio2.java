package session_06;

//Ejercicio 2: Cálculo de Potencias con Arrays
//Descripción: Crea un programa que reciba dos arreglos (3 valores): uno con bases y
//otro con exponentes. Utiliza un ciclo for para calcular la potencia de cada base
//elevada a su respectivo exponente usando Math.pow().

public class Ejercicio2 {
	public static void main(String[] args){
		//Declaracion de arreglos.
		double[] base = {3,6,9};
		double[] exponente = {2,4,6};
		double[] resultado = new double[base.length];

		for(int i=0; i<base.length; i++){
			resultado[i] = Math.pow(base[i], exponente[i]);
		}
		//Mostrar los resultados
		//Probando con foreach
		int indice=0;
		for(double i: resultado){
			System.out.println("El resultado de la base " + base[indice] + " por el exponente " + exponente[indice] + " es: " + resultado[indice]);
			indice++;
		}
		//  for(int i=0; i<resultado.length; i++){
		//    System.out.println("El resultado de la base " + base[i] + " por el exponente " + exponente[i] + " es: " + resultado[i]);
		//  }
	}
}


