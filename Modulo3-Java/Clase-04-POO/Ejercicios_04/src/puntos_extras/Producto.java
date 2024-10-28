package puntos_extras;

public class Producto {
	//Atributos de la clase
	private String nombre;
	private double precio;
	private Categoria categoria;

	//Constructor de la clase
	public Producto(String nombre, double precio, Categoria categoria){
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	//Setters y Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//Metodos de la clase
	public double precioConDescuento(){
		double descuento = categoria.getDescuento();
		precio = precio - (precio * descuento / 100);
		return precio;
	}

	@Override
	public String toString(){
		return nombre + ", precio: " + precio + "\nCategoria: " + categoria.toString();
	}
}

