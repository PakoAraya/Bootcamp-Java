package dia3.ejercicio1;

/**
 * @author  : Francisco Javier Araya
 * @version : 0.0.1
 * @since   : 11-10-2024
 */

public class Electrodomestico {
	protected String marca;
	protected String modelo;
	protected double consumo;

	public Electrodomestico(String marca, String modelo, double consumo){
		this.marca = marca;
		this.modelo = modelo;
		this.consumo = consumo;
	}

	//Metodo para obtener el consumo de energia
	public double getConsumo(){
		return consumo;
	}

	//Metodo toString
	@Override
	public String toString(){
		return "Marca: " + marca + ", Modelo: " + modelo + " consumo: " + consumo + " Watts";
	}
}
