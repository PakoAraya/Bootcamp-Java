package dia2.ejercicio2;

//Ejercicio 2: Clase genérica Par con métodos de acceso
//Enunciado:
//Crea una clase genérica Par<T, U> que almacene dos objetos de tipos T y U(atributos).
//Implementa métodos getPrimero() y getSegundo() para obtener cada valor y un
//metodo toString() para devolver una representación de ambos valores.
//En el main, crea un Par que almacene un Integer y un String, y otro Par que almacene
//un Double y un Character.
//System.out.println(par1); // Salida: Par [primero=100, segundo=Cien]
//System.out.println(par2); // Salida: Par [primero=3.14, segundo=π]

public class Ejercicio2 {
	public static void main(String[] args) {
		//Instanciacion objeto de la clase par1
		Par<Integer, String> par1 = new Par<>(100,"Cien");
		//Instanciacion objeto de la clase par2
		Par<Double, Character> par2 = new Par<>(3.14, 'π');

		//Imprimir los valores de los objetos
		System.out.println(par1);
		System.out.println(par2);
	}
}
