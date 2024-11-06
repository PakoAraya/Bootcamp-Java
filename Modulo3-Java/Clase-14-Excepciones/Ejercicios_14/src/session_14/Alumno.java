package session_14;

public class Alumno {
	private String nombre;
	private int edad;
	private double nota;

	public Alumno(String nombre, int edad, double nota){
		this.nombre = nombre;
		this.edad = edad;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getNota() {
		return nota;
	}

	@Override
	public String toString(){
		return nombre + "," + edad + "," + nota;
	}
}
