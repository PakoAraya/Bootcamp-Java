package ejercicio3;

//Clase Padre
public class Vehiculo {
	//Atributos de la clase
	private String marca;
	private String modelo;

	//Constructor de la clase
	public Vehiculo(String marca, String modelo){
		this.marca = marca;
		this.modelo = modelo;
	}

	//Setters y Getters de atributos
	public String getMarca(){
		return marca;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

	public String getModelo(){
		return modelo;
	}

	public void setModelo(String modelo){
		this.modelo = modelo;
	}

	//Metodo mostrarDetalles()
	protected void mostrarDetalles(){
		System.out.println("Marca: " + marca + ", Modelo: " + modelo);
	}
}
