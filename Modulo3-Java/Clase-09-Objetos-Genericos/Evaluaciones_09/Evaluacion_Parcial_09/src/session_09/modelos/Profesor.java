package session_09.modelos;

import java.util.Date;

public class Profesor extends Persona{
	public Profesor(String nombre, Date fechaNacimiento) {
		super(nombre, fechaNacimiento);
	}
	
	@Override
	public String toString() {
		return "Profesor - " + super.toString();
	}
}
