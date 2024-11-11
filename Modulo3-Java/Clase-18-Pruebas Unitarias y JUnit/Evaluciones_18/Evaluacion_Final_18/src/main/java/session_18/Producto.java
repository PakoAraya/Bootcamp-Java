package session_18;

import com.google.gson.Gson;

public class Producto {
	private String nombre;
	private int idProducto;
	private String condicion;
	private String precio;

	public Producto(String nombre, int idProducto, String condicion, String precio) {
		this.nombre = nombre;
		this.idProducto = idProducto;
		this.condicion = condicion;
		this.precio = precio;
	}

	public static Producto crearAviso(String nombre, int idProducto, String condicion, String precio) {
		return new Producto(nombre, idProducto, condicion, precio);
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	// Getters para pruebas unitarias
	public String getNombre() { return nombre; }
	public int getIdProducto() { return idProducto; }
	public String getCondicion() { return condicion; }
	public String getPrecio() { return precio; }
}
