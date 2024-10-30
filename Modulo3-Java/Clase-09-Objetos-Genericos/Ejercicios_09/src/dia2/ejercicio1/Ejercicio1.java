package dia2.ejercicio1;

//Ejercicio 1: Clase genérica Par
//Enunciado:
//Crea una clase genérica Par<T, U> que almacene dos valores (un par de datos), uno
//de tipo T y otro de tipo U.
//Implementa los métodos getPrimero() y getSegundo() para obtener cada valor del par,
//y un metodo toString() que devuelva una representación de ambos valores.

public class Ejercicio1 {
	public static void main(String[] args) {
		//Creando objeto con genericos
		Par<String, Integer> par = new Par<>("Maria",1);
		//Imprimiendo los valores del objeto
		System.out.println(par.getPrimero());
		System.out.println(par.getSegundo());
		System.out.println(par.toString());
	}
}
