package ejercicio3;

//Instruccion para la herencia
public class Coche extends Vehiculo{
	//Atributos de la clase Coche
	private int numeroPuertas;

	//Constructor de la clase Coche pero con superherencia
	public Coche(String marca, String modelo, int numeroPuertas){
		super(marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}

	//Setters y Getters de la clase Coche
	public int getNumeroPuertas(){
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas){
		this.numeroPuertas = numeroPuertas;
	}

	//Sobreescribir el metodo  mostrarDetalles()
	@Override
	public void mostrarDetalles(){
		super.mostrarDetalles();
		System.out.println("Coche con numero de puertas: " + numeroPuertas);
	}
}
