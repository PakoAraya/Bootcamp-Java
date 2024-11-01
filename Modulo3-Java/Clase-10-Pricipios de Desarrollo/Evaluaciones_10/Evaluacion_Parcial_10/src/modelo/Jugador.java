package modelo;

import interfaces.Amonestar;
import interfaces.RealizarAccionesJugador;

public class Jugador extends Persona implements Amonestar, RealizarAccionesJugador{
	private int numeroCamiseta;
	private String posicion;

	public Jugador(String nombre, String apellido, int edad, int numeroCamiseta, String posicion) {
		super(nombre, apellido, edad);
		this.numeroCamiseta = numeroCamiseta;
		this.posicion = posicion;
	}

	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public void recibirTarjetaAmarilla() {
		System.out.println(getNombre() + " " + getApellido() + " recibió una tarjeta amarilla.");
	}

	@Override
	public void recibirTarjetaRoja() {
		System.out.println(getNombre() + " " + getApellido() + " recibió una tarjeta roja.");
	}

	@Override
	public void correr() {
		System.out.println(getNombre() + " " + getApellido() + " está corriendo.");
	}

	@Override
	public void saltar() {
		System.out.println(getNombre() + " " + getApellido() + " está saltando.");
	}

	@Override
	public void quitarBalon() {
		System.out.println(getNombre() + " " + getApellido() + " está quitando el balón.");
	}

	@Override
	public String toString() {
		return super.toString() + ", Número de Camiseta: " + numeroCamiseta + ", Posición: " + posicion;
	}
}
