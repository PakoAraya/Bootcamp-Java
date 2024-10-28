package main;

class Producto {
	private String nombre;
	private int valor;
	private String descripcion;

	// Constructor para inicializar los atributos
	public Producto(String nombre, int valor, String descripcion) {
		this.nombre = nombre;
		this.valor = valor;
		this.descripcion = descripcion;
	}

	// Métodos getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Método para mostrar la información del producto
	public void mostrarProducto() {
		System.out.println("Nombre: " + nombre + " | Valor: " + valor + " | Descripción: " + descripcion);
	}
}
