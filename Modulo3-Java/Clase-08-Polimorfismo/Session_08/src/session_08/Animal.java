package session_08;

public class Animal {

	protected String nombre;
	protected int edad;

	Animal(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	Animal(){
	}

	public void generarSonido() {
		System.out.println("genera sonido");
	}
}
