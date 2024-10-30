package session_09.colecciones;

import java.util.ArrayList;
import java.util.List;

import session_09.modelos.Producto;

public class Bolsa<T extends Producto> {
	private List<T> items;
	private int capacidad;

	public Bolsa(int capacidad) {
		this.capacidad = capacidad;
		items = new ArrayList<>(capacidad);
	}

	public boolean agregarItem(T item) {
		if (items.size() < capacidad) {
			items.add(item);
			return true;
		} else {
			System.out.println("La bolsa está llena. No se pueden agregar más artículos.");
			return false;
		}
	}

	public void mostrarItems() {
		for (T item : items) {
			item.mostrarInfo();
		}
	}
}