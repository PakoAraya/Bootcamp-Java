package evaluacion;

public class Auto {
	//Atributos de la clase
	private String marca;
	private String modelo;
	private String color;
	private int velocidadMaxima;
	private boolean encendido;

	//Constructor de la clase
	public Auto(String marca, String modelo, String color, int velocidadMaxima){
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.velocidadMaxima = velocidadMaxima;
		this.encendido = false;
	}

	//Setters y Getters de la clase
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	//Metodos solicitados por el ejercicio
	public void encender(){
		if (encendido) {
			System.out.println("El auto ya esta encendido");
		}else {
			encendido = true;
			System.out.println("El auto ya se ha encendido");
		}
	}

	public void apagar(){
		if (!encendido) {
			System.out.println("El auto ya esta apagado");
		}else {
			encendido = false;
			System.out.println("El auto se ha apagado");
		}
	}

	public void acelerar(){
		if (!encendido) {
			System.out.println("No puedes acelerar el auto. El auto esta apagado");
		}else {
			System.out.println("El auto esta acelerando hasta la velocidad maxima de: " + velocidadMaxima + "Km/hr");
		}
	}

	//Mostrar los datos de la clase
	public void mostrarDatos(){
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Color: " + color);
		System.out.println("Velocidad Máxima: " + velocidadMaxima + "Km/hr.");
		System.out.println("Estado: " + (encendido ? "Encendido" : "Apagado"));
	}
}

