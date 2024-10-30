package session_09.modelos;

import java.util.Date;

public abstract class Persona {
	protected String nombre;
	protected Date fechaNacimiento;
	
	public Persona(String nombre, Date fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Fecha de Nacimiento: " + fechaNacimiento;
	}
}
