package ejercicio2;

public class Rectangulo extends Figura{
	private double largo, ancho;

	//Constructor de la clase
	public Rectangulo(double largo, double ancho){
		this.largo = largo;
		this.ancho = ancho;
	}

	//Setters y Getters
	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	//Metodo calcularPerimetro (Sobrecarga)
	@Override
	public double calcularPerimetro(){
		return 2 * (largo + ancho);
	}
}
