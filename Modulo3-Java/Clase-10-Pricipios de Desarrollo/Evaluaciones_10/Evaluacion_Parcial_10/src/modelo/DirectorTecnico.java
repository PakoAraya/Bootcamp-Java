package modelo;

import interfaces.Amonestar;

public class DirectorTecnico extends Persona implements Amonestar{
	private int aniosExperiencia;
	
	public DirectorTecnico(String nombre, String apellido, int edad, int aniosExperiencia) {
		super(nombre, apellido, edad);
		this.aniosExperiencia = aniosExperiencia;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}



	@Override
	public void recibirTarjetaAmarilla() {
		System.out.println(getNombre() + " " + getApellido() + " recibio una tarjeta amarilla.");
	}

	@Override
	public void recibirTarjetaRoja() {
		System.out.println(getNombre() + " " + getApellido() + " recibio una tarjeta roja.");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Años de Experiencia: " + aniosExperiencia;
	}
}
