package dia3.ejercicio1;

/**
 * @author  : Francisco Javier Araya
 * @Version : 0.0.1
 * @since   : 11-10-2024
 */

public class Television extends Electrodomestico{
	private int tamanio;
	private  String tipoPantalla;
	private String resolucion;
	private boolean smartTV;

	//Constructor de la clase
	public Television(String marca, String modelo, double consumo, int tamanio, String tipoPantalla, String resolucion, boolean smartTV){
		super(marca, modelo, consumo);
		this.tamanio = tamanio;
		this.tipoPantalla = tipoPantalla;
		this.resolucion = resolucion;
		this.smartTV = smartTV;
	}

	//Metodo para devolver el tamaño
	public int getTamanio(){
		return tamanio;
	}

	//Metodo toString con sobreescritura
	@Override
	public String toString() {
		return "Television [" +
				"smartTV=" + smartTV +
				", marca='" + marca + '\'' +
				", modelo='" + modelo + '\'' +
				", tamanio=" + tamanio +
				", tipoPantalla='" + tipoPantalla + '\'' +
				", resolucion='" + resolucion + '\'' +
				", consumo=" + consumo + " Watts" +
				']';
	}
}
