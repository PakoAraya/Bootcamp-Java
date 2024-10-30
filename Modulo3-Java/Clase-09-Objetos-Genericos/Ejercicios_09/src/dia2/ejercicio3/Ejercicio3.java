package dia2.ejercicio3;

//Ejercicio 3: Metodo genérico compararElementos
//Enunciado:
//Crea una clase Utilidades que contenga un metodo genérico compararElementos(T
//elemento1, T elemento2) que reciba dos elementos de tipo T y devuelva true si ambos
//elementos son iguales (elemento1.equals(elemento2)) y false en caso contrario.
//En el main, prueba el metodo compararElementos con diferentes tipos de datos,
//como String e Integer.

import dia2.ejercicio3.Utilidades;

public class Ejercicio3 {
	public static void main(String[] args) {
		//Gracias al static no es necesario instanciar y se puede invocar la clase
		//Utilidades.compararElementos(); o simplemente invocar al elemento comparElemento();

		//Probando con Strings
		String str1 = "Polimorfismo";
		String str2 = "Java";
		String str3 = "dormir";
		String str4 = "Java";

		//Aqui hacemos las comparaciones
		System.out.println(Utilidades.compararElementos(str1, str2));
		System.out.println(Utilidades.compararElementos(str2, str3));
		System.out.println(Utilidades.compararElementos(str2, str4));

		System.out.println();
		//Probar con Integers
		Integer num1 = 10;
		Integer num2 = 10;
		Integer num3 = 30;
		Integer num4 = 40;

		//Aqui mostramos las comparaciones de integers
		System.out.println(Utilidades.compararElementos(num1, num2));
		System.out.println(Utilidades.compararElementos(num2, num3));
		System.out.println(Utilidades.compararElementos(num3, num4));

		System.out.println();
		//Probando con doubles
		Double double1 = 4.15;
		Double double2 = 3.14;
		Double double3 = 4.15;
		Double double4 = 3.14;

		//Comparacion de doubles
		System.out.println(Utilidades.compararElementos(double1, double3));
		System.out.println(Utilidades.compararElementos(double2, double4));
	}
}
