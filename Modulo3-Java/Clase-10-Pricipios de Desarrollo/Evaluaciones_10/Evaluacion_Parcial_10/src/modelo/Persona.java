package modelo;

import interfaces.Hablar;
import interfaces.Celebrar;

public abstract class Persona implements Hablar, Celebrar{
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public void hablar() {
		System.out.println(nombre + " " + apellido + " esta hablando.");
	}
	
	@Override
	public void celebrar() {
		System.out.println(nombre + " " + apellido + " esta celebrando.");
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad;
	}
	
}
