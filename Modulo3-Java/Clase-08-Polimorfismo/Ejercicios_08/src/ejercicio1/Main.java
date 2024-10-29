package ejercicio1;

//Ejercicio 2: Clase Vehiculo con Sobrescritura de Métodos
//Crea una clase Vehiculo con un metodo arrancar(), y dos clases hijas Auto y Moto que
//sobrescriban el metodo arrancar() con diferentes mensajes:
//• Vehiculo imprime "El vehículo está arrancando".
//• Auto imprime "El Auto está arrancando".
//• Moto imprime "La moto está arrancando".
//Luego, crea un objeto de cada clase y llama al metodo arrancar() para cada uno,

public class Main {
	public static void main(String[] args) {
		//Creacion de los objetos de cada clase
		Vehiculo vehiculo = new Vehiculo();
		Auto auto = new Auto();
		Moto moto = new Moto();

		//llamando a los metodos arracar.
		vehiculo.arrancar();
		auto.arrancar();
		moto.arrancar();
	}
}
