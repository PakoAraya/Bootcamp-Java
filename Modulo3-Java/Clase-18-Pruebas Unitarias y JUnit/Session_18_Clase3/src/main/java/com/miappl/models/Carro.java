package com.miappl.models;

public class Carro {
	private final Motor motor;

	public Carro(Motor motor) {
		this.motor = motor;
	}

	public boolean encenderCarro() {
		return motor.encender();
	}

	public boolean apagarCarro() {
		return motor.apagar();
	}

	public String obtenerEstado() {
		return motor.estaEncendido() ? "El carro está encendido" : "El carro está apagado";
	}
}