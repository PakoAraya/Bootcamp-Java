package session_04.ejercicio2;

//Ejercicio 2: Clase Empleado
//Enunciado:
//Crea una clase Empleado con los siguientes atributos:
//• Atributo público: nombre (String)
//• Atributos privados: salario (double), edad (int)                                         √
//Requisitos:
//1. Implementa los getters y setters con las siguientes validaciones:
//o El salario debe ser mayor que 0.                                                         √
//o La edad debe estar entre 18 y 65.
//2. Sobrecarga el método toString() para mostrar la información del empleado.
//3. Crea un constructor que inicialice todos los atributos.

public class Ejercicio2 {
	public static void main(String[] args){
		//Instanciacion de clase empleado
		Empleado empleado = new Empleado();
		empleado.setNombre("Omar Sagredo");
		empleado.setSalario(25000.90);
		empleado.setEdad(45);

		//Imprimir datos del empleado
		System.out.println(empleado.toString());
	}
}
