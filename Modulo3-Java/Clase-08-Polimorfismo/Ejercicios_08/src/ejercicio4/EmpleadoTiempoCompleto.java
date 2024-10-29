package ejercicio4;

public class EmpleadoTiempoCompleto extends Empleado{
	private double salarioMensual;

	//Constructor de la clase
	public EmpleadoTiempoCompleto(double salarioMensual){
		this.salarioMensual = salarioMensual;
	}

	public EmpleadoTiempoCompleto() {
	}

	//Setters y Getters.
	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	//Metodo sobreescrito de calcularSalario
	@Override
	public double calcularSalario(){
		return salarioMensual;
	}
}

