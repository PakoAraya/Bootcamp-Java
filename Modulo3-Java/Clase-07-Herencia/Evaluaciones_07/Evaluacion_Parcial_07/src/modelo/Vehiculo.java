package modelo;

public abstract class Vehiculo {
	private int numeroRuedas;
	private int cantidadVentanas;

	public Vehiculo(int numeroRuedas, int cantidadVentanas) {
		this.numeroRuedas = numeroRuedas;
		this.cantidadVentanas = cantidadVentanas;
	}

	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
	}

	public int getCantidadVentanas() {
		return cantidadVentanas;
	}

	public void setCantidadVentanas(int cantidadVentanas) {
		this.cantidadVentanas = cantidadVentanas;
	}

	public abstract void encender();
	public abstract void apagar();
}