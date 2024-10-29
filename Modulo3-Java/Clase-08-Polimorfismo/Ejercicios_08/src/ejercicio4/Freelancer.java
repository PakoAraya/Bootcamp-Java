package ejercicio4;

public class Freelancer extends Empleado{
	private double tarifaPorProyecto;

	//Constructor de la clase
	public Freelancer(double tarifaPorProyecto){
		this.tarifaPorProyecto = tarifaPorProyecto;
	}

	//Setters y Getters de la clase
	public double getTarifaPorProyecto() {
		return tarifaPorProyecto;
	}

	public void setTarifaPorProyecto(double tarifaPorProyecto) {
		this.tarifaPorProyecto = tarifaPorProyecto;
	}

	//Sobreescribir el metodo calcularSalario
	@Override
	public double calcularSalario(){
		return tarifaPorProyecto;
	}
}
