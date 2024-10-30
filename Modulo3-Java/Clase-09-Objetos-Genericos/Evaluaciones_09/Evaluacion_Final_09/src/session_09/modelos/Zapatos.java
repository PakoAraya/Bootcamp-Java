package session_09.modelos;

public class Zapatos extends Producto {
	private String marca;

	public Zapatos(String marca) {
		this.marca = marca;
	}

	@Override
	public void mostrarInfo() {
		System.out.println("Marca de zapatos: " + marca);
	}
}