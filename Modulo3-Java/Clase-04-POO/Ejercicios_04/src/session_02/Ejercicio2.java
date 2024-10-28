package session_02;

//Ejercicio 2:
//o Crea una clase Producto con los atributos nombre y precio.
//o Sobrecarga el método toString() para devolver una cadena que muestre
//el nombre del producto y su precio.

public class Ejercicio2 {
	public static void main(String[] args){
		//Crear objetos de la clase Producto
		Producto producto1 = new Producto("Laptop",999.00);
		Producto producto2 = new Producto("Audifonos", 49.99);
		Producto producto3 = new Producto("Mouse", 24.99);

		//Imprimir la informacion de los objetos con toString
		System.out.println("Producto 1 con toString: " + producto1.toString());
		System.out.println("Producto 2 sin toString: " + producto2);
		System.out.println("Producto 3 con metodo: " + producto3.devolverNombre());
		System.out.println("Producto 3 con metodo: " + producto3.devolverPrecio());
	}
}

class Producto{
	//Atributos
	String nombre;
	double precio;

	//Constructor
	Producto(String nombre, double precio){
		this.nombre = nombre;
		this.precio = precio;
	}

	//Metodo toString con Override
	public String toString(){
		return ("Producto: " + nombre + ", Precio: " + precio);
	}

	// Metodo devolver solo el nombre
	public String devolverNombre(){
		return nombre;
	}

	// Metodo devolver solo el precio
	public double devolverPrecio(){
		return precio;
	}
}
