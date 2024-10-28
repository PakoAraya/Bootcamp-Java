package session_03;

//Ejercicio 4: Clase Rectángulo 1pts
//Crea una clase Rectangulo con los siguientes atributos:
//• ancho (double)
//• alto (double)
//• color (String)
//• material (String)
//• nombre (String)
//Métodos:
//• Un metodo para calcular el área del rectángulo.
//• Un metodo para calcular el perímetro del rectángulo.
//• Sobrecarga del metodo toString() para mostrar la información del rectángulo.

public class Ejercicio4 {
	public static void main(String[] args){
		RectanguloA rectangulo1 = new RectanguloA(5.0, 3.0, "Rojo", "Madera", "Rectangulo 1");

		//Mostrar los datos
		System.out.println(rectangulo1.toString());
	}
}

//Creacion de clase Rectangulo
class RectanguloA{
	//Atributos
	double ancho;
	double alto;
	String color;
	String material;
	String nombre;

	//Constructor de la clase
	RectanguloA(double ancho, double alto, String color, String material, String nombre){
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		this.material = material;
		this.nombre = nombre;
	}

	//Metodo para calcular area de rectangulo
	double calcularArea(){
		return ancho * alto;
	}

	//Metodo para calcular el perimetro de rectangulo
	double calcularPerimetro(){
		return 2 * (ancho + alto);
	}

	//Metodo toString
	public String toString(){
		return ("Rectangulo: \nAncho: " + ancho + ", \nAlto " + alto + ", \nColor " + color + ", \nMaterial " + ", \nNombre: " + nombre + ", \nArea: " + calcularArea() + ", \nPerimetro: " + calcularPerimetro());
	}
}