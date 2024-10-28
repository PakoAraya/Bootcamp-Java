package puntos_extras;

public class Main {
	public static void main(String[] args) {
		//Creacion de objetos y prueba de codigos
		Direccion direccion = new Direccion("Av. Principal 123", "Santiago", "Chile");
		Cliente cliente = new Cliente("Juan Pérez", 70, direccion);
		Categoria categoria = new Categoria("Electrónica", 15);
		Producto producto = new Producto("Televisor", 500, categoria);
		Compra compra = new Compra(cliente, producto);

		System.out.println("Los detalles total de la compra son: ");
		System.out.println(compra.toString());
	}
}
