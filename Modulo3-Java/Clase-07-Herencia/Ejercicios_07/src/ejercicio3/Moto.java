package ejercicio3;

//Intruccion para la herencia
public class Moto extends Vehiculo{
	//Atributos de la clase
	private String color;

	//Constructor de la clase Moto
	public Moto(String marca, String modelo, String color){
		super(marca, modelo);
		this.color = color;
	}

	//Setters y Getters de la clase Moto
	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

	//Metodo  mostrarDetalles() con sobreescritura
	public void mostrarDetalles(){
		super.mostrarDetalles();
		System.out.println("la moto tiene el color: " + color);
	}
}

