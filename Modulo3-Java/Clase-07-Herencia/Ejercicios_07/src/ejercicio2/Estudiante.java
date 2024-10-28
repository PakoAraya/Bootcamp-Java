package ejercicio2;

//Heredo de la clase persona
public class Estudiante extends Persona{
	private String apellido;

	//Genero el constructor de la clase y uso super para invocar el constructor de Persona
	public Estudiante(String nombre){
		super(nombre);
	}

	//Genero los setters y getters de apellido
	public String getApellido(){
		return apellido;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}

	//Sobreescribir el metodo saludar.
	@Override
	public void saludar(){
		super.saludar();
		System.out.println("Soy el estudiante");
	}
}
