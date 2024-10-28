package session_03;

//Ejercicio 2: Clase Triangulo 2pts
//Crea una clase Triangulo con los siguientes atributos:                                  √
//• base (double)
//• altura (double)
//• lado1 (double)
//• lado2 (double)
//• tipo (String)

//Métodos:
//• Un metodo para calcular el área del triángulo.                                        √
//• Un metodo para calcular el perímetro del triángulo.                                   √
//• Sobrecarga del metodo toString() para mostrar la información del triángulo.           √

public class Ejercicio2 {
	public static void main(String[] args){
		Triangulo triangulo1 = new Triangulo(4.5, 8.3, 9.6, 6.4, "Escaleno");

		//Imprimir los datos
		System.out.println(triangulo1);
	}
}

//Crear clase triangulo
class Triangulo{
	//Atributos
	double base;
	double altura;
	double lado1;
	double lado2;
	String tipo;

	//constructor de la clase
	Triangulo(double base, double altura, double lado1, double lado2, String tipo){
		this.base = base;
		this.altura = altura;
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.tipo = tipo;
	}

	//Metodo para el area del triangulo
	double calcularArea(){
		return (base * altura)/2;
	}

	//Metodo para el calculo del perimetro
	double calcularPerimetro(){
		return (base + lado1 + lado2);
	}

	//Metodo toString
	public String toString(){
		return ("Triangulo base:" + base + ", Altura: " + altura + ", lado1 " + lado1 + ", lado2 " + lado2 + ", Area: " + calcularArea() + ", Perimetro: " + calcularPerimetro() + ", tipo: " + tipo);
	}
}