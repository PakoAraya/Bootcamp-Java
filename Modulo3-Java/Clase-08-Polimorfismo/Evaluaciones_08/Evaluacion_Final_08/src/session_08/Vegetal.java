package session_08;

public class Vegetal implements Producto {
	private String nombre;
	private String codigo;
	private double precio;
	private String fechaEnvasado;
	private String fechaCaducidad;

	public Vegetal(String nombre, String codigo, double precio, String fechaEnvasado, String fechaCaducidad) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.fechaEnvasado = fechaEnvasado;
		this.fechaCaducidad = fechaCaducidad;
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
		System.out.println("Vegetal: " + nombre + ", Código: " + codigo + ", Precio: $" + precio + ", Envasado: " + fechaEnvasado + ", Caducidad: " + fechaCaducidad);
	}
}