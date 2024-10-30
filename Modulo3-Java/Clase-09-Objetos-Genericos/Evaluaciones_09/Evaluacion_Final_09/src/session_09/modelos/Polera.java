package session_09.modelos;

public class Polera extends Producto {
	private String color;

	public Polera(String color) {
		this.color = color;
	}

	@Override
	public void mostrarInfo() {
		System.out.println("Color de la polera: " + color);
	}
}