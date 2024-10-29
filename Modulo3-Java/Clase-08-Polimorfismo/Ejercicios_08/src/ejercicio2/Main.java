package ejercicio2;

//Ejercicio 3: Figuras Geométricas con Polimorfismo
//Crea una clase abstracta Figura con un metodo abstracto calcularPerimetro(). Luego,         √
//crea las clases hijas Triangulo y Rectangulo, cada una con sus propios atributos            √
//(como base, altura o lados) y sobrescribiendo el metodo calcularPerimetro() para
//calcular el perímetro correspondiente de cada figura.                                       √

public class Main {
	public static void main(String[] args) {
		//Instanciacion de objetos
		//Crear Triangulo
		Triangulo triangulo = new Triangulo(3,4,5);
		System.out.println("El perimetro del triangulo es: "  + triangulo.calcularPerimetro());

		System.out.println();

		//Crear objeto rectangulo
		Rectangulo rectangulo = new Rectangulo(4, 8);
		System.out.println("El perimetro del rectangulo es: "+ rectangulo.calcularPerimetro());
	}
}
