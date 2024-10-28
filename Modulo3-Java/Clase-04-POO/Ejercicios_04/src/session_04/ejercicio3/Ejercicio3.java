package session_04.ejercicio3;

//Ejercicio 3: Clase Producto
//Enunciado:
//Crea una clase Producto con los siguientes atributos:
//• Atributo público: nombre (String)
//• Atributos privados: precio (double), stock (int)                                  √
//
//Requisitos:
//1. Implementa los getters y setters con las siguientes validaciones:
//o El precio debe ser mayor que 0.                                                   √
//o El stock debe ser igual o mayor que 0.
//2. Sobrecarga el metodo toString() para mostrar la información del producto.
//3. Crea un constructor que inicialice todos los atributos.

public class Ejercicio3 {
	public static void main(String[] args){
		Producto p1 = new Producto();
		Producto p2 = new Producto();

		//Creando objeto 1
		p1.setNombre("Cereal");
		p1.setPrecio(-230);
		p1.setStock(-50);
		System.out.println(p1.toString());

		System.out.println();

		//Creando objeto2
		p2.setNombre("Bebida");
		p2.setPrecio(350);
		p2.setStock(50);
		System.out.println(p2.toString());
	}
}

