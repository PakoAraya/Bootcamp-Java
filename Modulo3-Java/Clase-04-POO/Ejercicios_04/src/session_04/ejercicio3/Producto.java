package session_04.ejercicio3;

public class Producto {
	//Atributos de la clase
	public String nombre;
	private double precio;
	private int stock;

	//Constructor vacio
	Producto(){

	}

	//Setters y Getters
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public double getPrecio(){
		return precio;
	}

	public void setPrecio(int precio){
		if(precio > 0 ){
			this.precio = precio;
		}else{
			this.precio = 0;
		}
	}

	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		if(stock > 0){
			this.stock = stock;
		}else{
			this.stock = 0;
		}
	}

	@Override
	public String toString(){
		return "Producto nombre: " + nombre + ", precio: " + precio + ", stock: " + stock;
	}
}
