package session_07;

public class Animal {
	//Atributos
	protected String nombre;
	protected int edad;

	//Tambien podemos tener un constructor vacio
	Animal(){

	}

	Animal(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}

	public void generarSonido(){
		System.out.println("genera sonido");
	}
}
