package session_04;

public class PooClass {
	public static void main(String[] args) {
		Auto auto1 = new Auto();
		Auto auto2 = new Auto("Toyota");
		Auto auto3 = new Auto("Toyota", "Azul");
		Auto auto4 = new Auto("Toyota", "Azul", 2024);
		System.out.println(auto1.marca);
		System.out.println(auto2.marca);
		System.out.println(auto3.marca + " " + auto3.color);
		System.out.println(auto4.marca + " " + auto4.color + " " + auto4.anio);
	}
}

//Definicion clase auto
class Auto{
	//Atributos
	String marca;
	String color;
	String modelo;
	int anio;
	
	//Constructor por defecto ya existe
	
	//Constructor vacio (sin parametros)
	Auto(){
		this.marca = "Mazda";
	}
	
	//Constructor con parametros
	Auto(String marcaParametro){
		this.marca = marcaParametro;
	}
	
	Auto(String marcaParametro, String colorParametro){
		this.marca = marcaParametro;
		this.color = colorParametro;
	}
	
	//Constructor con parametros completo
	Auto(String marcaParametro, String colorParametro, int anioParametro){
		this.marca = marcaParametro;
		this.color = colorParametro;
		this.anio = anioParametro;
	}
}
