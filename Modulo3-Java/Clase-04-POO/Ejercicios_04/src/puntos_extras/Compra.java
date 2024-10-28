package puntos_extras;

public class Compra {
	//Atributos de la clase
	private Cliente cliente;
	private Producto producto;

	//Constructor de la clase
	public Compra(Cliente cliente, Producto producto){
		this.cliente = cliente;
		this.producto = producto;
	}

	//Setters y Getters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	//Metodos de la clase
	public double calcularPrecioTotal(){
		double precioConDescuento = producto.precioConDescuento();
		double descuentoAdicional = cliente.obtenerDescuentoPorEdad();
		return precioConDescuento - (precioConDescuento * descuentoAdicional / 100);
	}

	@Override
	public String toString() {
		return "Compra: " + cliente.toString() + "\nProducto: " + producto.toString() + "\nPrecio Total: $" + calcularPrecioTotal();
	}
}

