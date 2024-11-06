package session_14;

import java.util.Objects;

public class Socio {
	private String nombre;
	private int edad;
	private String cargo;

	public Socio(String nombre, int edad, String cargo) {
		this.nombre = nombre;
		this.edad = edad;
		this.cargo = cargo;
	}

	public String getNombre() { return nombre; }
	public int getEdad() { return edad; }
	public String getCargo() { return cargo; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Socio socio = (Socio) o;
		return edad == socio.edad && nombre.equals(socio.nombre) && cargo.equals(socio.cargo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, edad, cargo);
	}

	@Override
	public String toString() {
		return "Socio: " + nombre + ", Edad: " + edad + ", Cargo: " + cargo;
	}
}