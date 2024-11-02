package session_02.ejercicio1;

public class Alumno {
	private String nombre;
	private int edad;
	private double nota;

	public Alumno(String nombre, int edad, double nota){
		this.nombre = nombre;
		this.edad = edad;
		this.nota = nota;
	}

	//Setters y Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	//Metodo toString sobrescrito
	@Override
	public String toString(){
		return nombre + ", " + edad + ", " + nota;
	}
}
