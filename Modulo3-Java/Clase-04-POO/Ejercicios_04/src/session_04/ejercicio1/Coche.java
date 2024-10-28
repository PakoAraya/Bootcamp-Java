package session_04.ejercicio1;

public class Coche {
	//Atributos de clase coche
	public String marca;
	private String modelo;
	private int anio;
	private double precio;

	//Constructor Vacio
	public Coche(){

	}

	//Constructor
	public Coche(String marca, String modelo, int anio, double precio){
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio; //Revisar mas adelante
		this.precio = precio;
	}

	//Setters y Getters
	public void setMarca(String marca){
		this.marca = marca;
	}

	public String getMarca(){
		return marca;
	}

	public void setModelo(String modelo){
		this.modelo = modelo;
	}

	public String getModelo(){
		return modelo;
	}

	public void setAnio(int anio){
		if (anio > 1886) {
			this.anio = anio;
		}else {
			this.anio = 1886;
		}
	}

	public int getAnio(){
		return anio;
	}

	public void setPrecio(double precio){
		if(precio > 0){
			this.precio = precio;
		}else{
			this.precio = 0;
		}
	}

	public double getPrecio(){
		return precio;
	}

	//Sobrecarga toString
	@Override
	public String toString(){
		return "Coche marca: " + marca + ", modelo " + modelo + ", año " + anio + ", precio= " + precio;
	}
}

