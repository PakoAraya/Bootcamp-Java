package ejercicio4;

public class EmpleadoMedioTiempo extends EmpleadoTiempoCompleto{
	private double salarioPorHora;
	private int horasTrabajadas;

	//Constructor de la clase
	public EmpleadoMedioTiempo(double salarioPorHora, int horasTrabajadas){
		this.salarioPorHora = salarioPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}

	//Setters y Getters
	public double getSalarioPorHora() {
		return salarioPorHora;
	}

	public void setSalarioPorHora(double salarioPorHora) {
		this.salarioPorHora = salarioPorHora;
	}

	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	//Metodo a sobreescribir
	@Override
	public double calcularSalario(){
		return salarioPorHora * horasTrabajadas;
	}
}
