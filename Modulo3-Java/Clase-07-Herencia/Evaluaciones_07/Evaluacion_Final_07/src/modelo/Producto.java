package modelo;

public abstract class Producto {
	private double precio;
	private int cantidadDisponible;

	public Producto(double precio, int cantidadDisponible) {
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void reducirCantidadDisponible() {
		if (cantidadDisponible > 0) {
			cantidadDisponible--;
		} else {
			System.out.println("Producto no disponible en inventario.");
		}
	}
}