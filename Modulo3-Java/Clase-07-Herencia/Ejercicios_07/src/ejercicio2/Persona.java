package ejercicio2;

public class Persona {
	//Atributo de la clase
	private String nombre;

	//Generar el constructor de la clase
	public Persona(String nombre){
		this.nombre = nombre;
	}

	//Setters y Getters
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	//Metodo saludo generico con nombre
	public void saludar(){
		System.out.println("Hola, mi nombres es: " + nombre);
	}
}
