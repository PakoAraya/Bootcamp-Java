package modelo;

import interfaces.CocinaInterface;

public class Cocina extends Producto implements CocinaInterface {
	private int cantidadQuemadores;

	public Cocina(double precio, int cantidadDisponible, int cantidadQuemadores) {
		super(precio, cantidadDisponible);
		this.cantidadQuemadores = cantidadQuemadores;
	}

	public int getCantidadQuemadores() {
		return cantidadQuemadores;
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
	public boolean incluyeGas(boolean incluyeGas) {
		return incluyeGas;
	}

	@Override
	public String toString() {
		return "Cocina{" +
				"precio=" + getPrecio() +
				", cantidadDisponible=" + cantidadDisponible() +
				", cantidadQuemadores=" + cantidadQuemadores +
				'}';
	}
}