package session_08;

import java.util.ArrayList;
import java.util.List;

// Clase base para la lista de miembros del curso
abstract class CursoMiembro {
	protected String nombre;
	protected int identificador;

	public CursoMiembro(String nombre, int identificador) {
		this.nombre = nombre;
		this.identificador = identificador;
	}

	public abstract void leer();
	public abstract void realizarEjercicios();
	public abstract void mostrarDatos();
}