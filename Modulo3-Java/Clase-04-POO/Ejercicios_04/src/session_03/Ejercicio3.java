package session_03;
//Ejercicio 3: Interacción de Clases Empleado y Departamento 3pts
//Crea una clase Empleado con los siguientes atributos:                               √
//• nombre (String)
//• edad (int)
//• salario (double)
//• puesto (String)
//• departamento (de tipo Departamento)

//Crea una clase Departamento con los atributos:                                      √
//• nombreDepartamento (String)
//• jefeDepartamento (String)

//Métodos:
//• Sobrecarga el metodo toString() en ambas clases para mostrar la información.      √
//del empleado y el departamento.

public class Ejercicio3 {
	public static void main(String[] args){
		//Vamos a crear el objeto Departamento
		Departamento departamento1 = new Departamento("Tecnologia", "Esilda Araneda");

		//Vamos a crear el objeto Empleado
		Empleado empleado1 = new Empleado("Maria Camejo", 28, 3000000, "Senior Developer", departamento1);

		//Mostrar la informacion
		System.out.println(empleado1.toString());
	}
}

//Creacion de clase departamento
class Departamento{
	//Atributos
	String nombreDepartamento;
	String jefeDepartamento;

	//Constructor de la clase
	Departamento(String nombreDepartamento, String jefeDepartamento){
		this.nombreDepartamento = nombreDepartamento;
		this.jefeDepartamento = jefeDepartamento;
	}

	//Metodo toString
	@Override
	public String toString(){
		return ("Departamento: " + nombreDepartamento + " y el Jefe es: " + jefeDepartamento);
	}
}

class Empleado{
	//Atributos
	String nombre;
	int edad;
	double salario;
	String puesto;
	Departamento departamento;

	//Constructor de la clase
	Empleado(String nombre, int edad, double salario, String puesto, Departamento departamento){
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
		this.puesto = puesto;
		this.departamento = departamento;
	}

	//Metodo toString
	@Override
	public String toString(){
		return ("Empleado: " + nombre + ", edad: " + edad + ", salario: " + salario + ", puesto: " + puesto + " " + departamento.toString());
	}
}