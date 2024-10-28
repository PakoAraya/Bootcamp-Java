package session_04.ejercicio2;

public class Empleado {
	//Atributos
	public String nombre;
	private double salario;
	private int edad;

	//Constructor vacio
	public Empleado(){

	}

	//Setters y Getters
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public double getSalario(){
		return salario;
	}

	public void setSalario(double salario){
		if(salario > 0){
			this.salario = salario;
		}else {
			this.salario = 0;
		}
	}

	public int getEdad(){
		return edad;
	}

	public void setEdad(int edad){
		if(edad >=18 && edad <= 65){
			this.edad = edad;
		}else{
			this.edad = 0;
		}
	}

	//Metodo toString
	@Override
	public String toString(){
		return "Empleado nombre: " + nombre + ", salario: " + salario + ", edad: " + edad;
	}
}
