package session_04.ejercicio1;

//Ejercicio 1: Clase Coche
//Enunciado:
//Crea una clase Coche que tenga los siguientes atributos:
//• Atributo público: marca (String)
//• Atributos privados: modelo (String), año (int), precio (double)                            √
//Requisitos:

//1. Implementa los getters y setters para los atributos privados con las siguientes
//validaciones:
//o El año debe ser mayor que 1886 (el año en que se inventó el automóvil).                    √
//o El precio debe ser positivo.
//2. Sobrecarga el metodo toString() para mostrar la información completa del
//coche.
//3. Crea un constructor que inicialice todos los atributos.                                   √

public class Ejercicio1 {
	public static void main(String[] args){
		//Coche miCoche = new Coche("Toyota", "Supra", 2024, 35000.0);
		Coche miCoche = new Coche();
		miCoche.setMarca("Toyota");
		miCoche.setModelo("Supra");
		miCoche.setAnio(2024);
		miCoche.setPrecio(35000.0);

		System.out.println(miCoche.toString());
		System.out.println();

		//Salida al sistema por getters
		System.out.println("Coche marca: " + miCoche.getMarca());
		System.out.println("Coche modelo: " + miCoche.getModelo());
		System.out.println("Coche Año: " + miCoche.getAnio());
		System.out.println("Coche Precio: " + miCoche.getPrecio());

	}
}

