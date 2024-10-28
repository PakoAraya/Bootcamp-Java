package session_07;

public class Perro extends Animal{
	//Atributo de solo tiene la subclase
	public String raza = "Quiltro";

	//Tenemos que crear el constructo de la clase, pero usando la palabra super
	Perro(String nombre, int edad){
		//super(String nombre, int edad);
		super(nombre, edad);
	}
	//Y tambien tenemos la opcion de poder crear un constructor vacio en la herencia
	Perro(){
		super();
	}

	//Para usar sobreescritura
	//Se puede cambiar funcionamiento o complementar
	@Override
	public void generarSonido(){
		//super.generarSonido(); Tambien se puede combinar
		System.out.println("Guau Guau");
	}

	//Llamar directamente al metodo del padre tal como es
	public void generarSonidoPadre(){
		super.generarSonido();
	}
}
