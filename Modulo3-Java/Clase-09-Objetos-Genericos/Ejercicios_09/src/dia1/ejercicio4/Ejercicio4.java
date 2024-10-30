package dia1.ejercicio4;

//Ejercicio 4: Exploración de getClass()
//1. Crea una clase Vehiculo y una clase Coche que herede de Vehiculo.
//2. En el main, crea un objeto de Coche y usa getClass() para imprimir la clase del
// objeto.
//3. Prueba los métodos getName(), getSimpleName() y getSuperclass() para
//obtener información detallada sobre la clase del objeto.

public class Ejercicio4 {
	public static void main(String[] args) {
		//Creando objeto de la clase coche
		Coche coche = new Coche();

		//Obteniendo los datos usando getClass
		System.out.println("Datos de la clase: " + coche.getClass());
		//Obteniendo nombre de la clase con todos los detalles
		System.out.println("Nombre completo de la clase: " + coche.getClass().getName());
		//Obteniendo nombre simple de la clase
		System.out.println("Nombre simple de la clase: " + coche.getClass().getSimpleName());
		//Obteniendo nombre de la super clase
		System.out.println("Nombre de la super clase: " + coche.getClass().getSuperclass().getName());
	}
}
