package ejercicio4;

//Ejercicio 5: Empleados y Salarios
//Crea una clase Empleado con un metodo calcularSalario() que devuelve un salario
//base. Luego,                                                                                     √
//
//crea tres clases hijas EmpleadoTiempoCompleto,
//EmpleadoMedioTiempo, y Freelancer, cada una con una implementación diferente de
//calcularSalario():
//• EmpleadoTiempoCompleto tiene un salario fijo mensual.
//• EmpleadoMedioTiempo tiene un salario por hora multiplicado por una
//cantidad específica de horas.
//• Freelancer tiene una tarifa por proyecto.

public class Main {
	public static void main(String[] args) {
		//Creacion de los objetos
		//Crear objeto empleado tiempo completo
		EmpleadoTiempoCompleto etc = new EmpleadoTiempoCompleto(2000);
		System.out.println("Salario del Empleado de tiempo completo es: " + etc.calcularSalario());

		//Crear objeto empleado medio tiempo
		EmpleadoMedioTiempo emt = new EmpleadoMedioTiempo(15, 80);
		System.out.println("Salario del empleado de medio tiempo por 80 horas de trabajo: " + emt.calcularSalario());

		//Crear objeto empleado freelancer
		Freelancer frel = new Freelancer(3000);
		System.out.println("Salario del Freelancer: " + frel.calcularSalario());
	}
}
