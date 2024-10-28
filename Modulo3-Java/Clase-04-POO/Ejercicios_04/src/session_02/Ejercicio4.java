package session_02;

//4. Ejercicio 4:
//o Crea una clase Coche con los atributos marca y modelo.
//o Sobrecarga el metodo toString() para mostrar la información del coche.  √
//o Luego crea una clase Concesionario con un atributo nombre y un
//objeto Coche. Sobrecarga el metodo toString() en Concesionario.  √

public class Ejercicio4 {
	public static void main(String[] args){
		Coche coche1 = new Coche("Nissan", "Skyline GT-R");
		Concesionario cons1 = new Concesionario("Autoplaza", coche1);

		Coche coche2 = new Coche("Subaru", "BRZ");
		Concesionario cons2 = new Concesionario("McQueen", coche2);

		//Imprimir resultados
		System.out.println("Datos Coche 1: " + coche1);
		System.out.println("Datos Coche 2: " + coche2);
	}
}

//Clase Coche
class Coche{
	//Atributos
	String marca;
	String modelo;

	//Constructor de la clase
	Coche(String marca, String modelo){
		this.marca = marca;
		this.modelo = modelo;
	}

	//Metodo toString
	@Override
	public String toString(){
		return "Coche: " + marca + ", modelo: " + modelo;
	}
}

//Clase Concesionario
class Concesionario{
	//Atributos
	String nombre;
	Coche coche;

	//Constructor
	Concesionario(String nombre, Coche coche){
		this.nombre = nombre;
		this.coche = coche;
	}

	//Metodo toString de Concesionario
	@Override
	public String toString(){
		return "Concesionario: " + nombre + ", " + coche.toString();
	}
}
