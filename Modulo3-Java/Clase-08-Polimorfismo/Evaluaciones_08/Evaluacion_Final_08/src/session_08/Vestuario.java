package session_08;

public class Vestuario implements Producto {
	private String nombre;
	private String codigo;
	private double precio;
	private String talla;
	private String color;

	public Vestuario(String nombre, String codigo, double precio, String talla, String color) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.talla = talla;
		this.color = color;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Vestuario: " + nombre + ", Código: " + codigo + ", Precio: $" + precio + ", Talla: " + talla + ", Color: " + color);
	}
}