package modelo;

import interfaces.ProductoInterface;

public class Refrigerador extends Producto implements ProductoInterface {
	private String tipoGastoElectrico; // Ej. A, B, C, D, E
	private int numeroPuertas;

	public Refrigerador(double precio, int cantidadDisponible, String tipoGastoElectrico, int numeroPuertas) {
		super(precio, cantidadDisponible);
		this.tipoGastoElectrico = tipoGastoElectrico;
		this.numeroPuertas = numeroPuertas;
	}

	public String getTipoGastoElectrico() {
		return tipoGastoElectrico;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	@Override
	public void cambiarPrecio(double nuevoPrecio) {
		setPrecio(nuevoPrecio);
	}

	@Override
	public int cantidadDisponible() {
		return getCantidadDisponible();
	}

	@Override
	public String toString() {
		return "Refrigerador{" +
				"precio=" + getPrecio() +
				", cantidadDisponible=" + cantidadDisponible() +
				", tipoGastoElectrico='" + tipoGastoElectrico + '\'' +
				", numeroPuertas=" + numeroPuertas +
				'}';
	}
}