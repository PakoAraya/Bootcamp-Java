package dia1.ejercicio1;

public class Persona {
	//Atributos
	private String nombre;
	private int edad;

	//constructor de la clase
	public Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
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

	//Metodo toString
	@Override
	public String toString(){
		return "Nombre: " + nombre + ", edad: " + edad;
	}
}
