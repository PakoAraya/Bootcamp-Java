package session_02.consolidado;

public class Alumno {
	private String nombre;
	private String rut;

	//constructor
	public Alumno(String nombre, String rut){
		this.nombre = nombre;
		this.rut = rut;
	}
	//getters

	public String getNombre() {
		return nombre;
	}

	public String getRut(){
		return rut;
	}
	//ToString
	@Override
	public String toString(){
		return "Nombre: " + nombre + ", R.U.T: " + rut;
	}
}
