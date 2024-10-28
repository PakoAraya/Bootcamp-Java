package session_02;

//Ejercicio 6:
//o Crea una clase Empleado con los atributos nombre y salario.
//o Sobrecarga el metodo toString() para mostrar la información del   √
//empleado.
//o Luego crea una clase Empresa con el atributo nombreEmpresa y un   √
//objeto Empleado. Sobrecarga el metodo toString() para mostrar la
//información de la empresa y el empleado.                            √

public class Ejercicio6 {
	public static void main(String[] args){
		Empleado empleado1 = new Empleado("Karla Jara", 50000);
		Empresa empresa1 = new Empresa("Tech Solutions", empleado1);

		Empleado empleado2 = new Empleado("Mario Kurtis", 60000);
		Empresa empresa2 = new Empresa("Innovatech",empleado2);

		//Impresion de la informacion entregada.
		System.out.println("Informacion Empresa 1: " + empresa1);
		System.out.println("Informacion Empresa 2: " + empresa2);
	}
}

//Clase Empleado
class Empleado{
	//Atributos
	String nombre;
	double salario;

	//Constructor
	Empleado (String nombre, double salario){
		this.nombre = nombre;
		this.salario = salario;
	}

	//Metodo Override
	@Override
	public String toString(){
		return "Empleado: " + nombre + ", Salario: $" + salario;
	}
}

//Clase Empresa
class Empresa{
	//Atributos
	String nombre;
	Empleado empleado;

	//Constructo de la clase
	Empresa(String nombre, Empleado empleado){
		this.nombre = nombre;
		this.empleado = empleado;
	}

	//Metodo Override
	public String toString(){
		return "Empresa: " + nombre + ", " + empleado.toString();
	}
}
