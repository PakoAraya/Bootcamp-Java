package session_09.modelos;

import java.util.Date;
import java.util.List;

public class Alumno extends Persona{
	private List<String> tareasPendientes;
	
	public Alumno(String nombre, Date fechaNacimiento, List<String> tareasPendientes) {
		super(nombre, fechaNacimiento);
		this.tareasPendientes = tareasPendientes;
	}
	
	public List<String> getTareasPendientes(){
		return tareasPendientes;
	}
	
	@Override
	public String toString() {
		return "Alumno - " + super.toString() + ", Tareas Pendientes: " + tareasPendientes;
	}
}
