package session_03;

//Ejercicio 1: Clase Cuadrado 1pts
//Crea una clase Cuadrado con los siguientes atributos:
//• lado (double)
//• color (String)
//• material (String)
//• unidadMedida (String)
//• nombre (String)                                                               √

//Métodos:
//• Un metodo para calcular el área del cuadrado.                                 √
//• Un metodo para calcular el perímetro del cuadrado.                            √
//• Sobrecarga del metodo toString() para mostrar la información del cuadrado.

public class Ejercicio1 {
	public static void main(String[] args){
		Cuadrado cuadrado1 = new Cuadrado(4, "Cyan", "Metalico", "cm", "Mi Cuadrado 1");

		//Imprimir el objeto en consola
		System.out.println(cuadrado1.toString());
	}
}

class Cuadrado{
	double lado;
	String color;
	String material;
	String unidadMedida;
	String nombre;

	//Constructor de la clase
	Cuadrado(double lado, String color, String material, String unidadMedida, String nombre){
		this.lado = lado;
		this.color = color;
		this.material = material;
		this.unidadMedida = unidadMedida;
		this.nombre = nombre;
	}

	//Metodo para calcular el area
	double calcularArea(){
		return lado * lado;
	}

	//Metodo para calcular el perimetro
	double calcularPerimetro(){
		return 4 * lado;
	}

	//Metodo toString
	@Override
	public String toString(){
		return ("Cuadrado tiene un lado de: " + lado + ", un color: " + color + ", construido de: " + material + ", con un Área de: " + calcularArea() + " " + unidadMedida + " y un perimetro de: " + calcularPerimetro() + " " + unidadMedida);
	}
}