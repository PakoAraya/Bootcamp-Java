package modelo;

import interfaces.InterfazVehiculo;

public class Auto extends Vehiculo implements InterfazVehiculo {
	private String color;
	private String modelo;

	public Auto(int numeroRuedas, int cantidadVentanas, String color, String modelo) {
		super(numeroRuedas, cantidadVentanas);
		this.color = color;
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String tipoDeBencina() {
		return "Gasolina";
	}

	@Override
	public void encender() {
		System.out.println("El auto está encendido.");
	}

	@Override
	public void apagar() {
		System.out.println("El auto está apagado.");
	}

	@Override
	public String toString() {
		return "Auto{" +
				"color='" + color + '\'' +
				", modelo='" + modelo + '\'' +
				", ruedas=" + getNumeroRuedas() +
				", ventanas=" + getCantidadVentanas() +
				'}';
	}
}