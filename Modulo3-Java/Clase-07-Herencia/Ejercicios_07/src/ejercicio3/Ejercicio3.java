package ejercicio3;

//Enunciado:
//Crea una clase padre llamada Vehiculo que tenga atributos marca y modelo, y un
//m3todo mostrarDetalles().                                                                  √
//
//Luego, crea dos clases hijas Coche y Moto, que
//sobrescriban el m3todo mostrarDetalles() para incluir información adicional, pero
//invocando también el m3todo de la clase padre con super.

public class Ejercicio3 {
	public static void main(String[] args) {
		//Instanciacion del objeto Coche
		Vehiculo coche = new Coche("Toyota", "Corolla", 4); //Dudas porque puedo instancias Vehiculo y Coche
		Coche coche1 = new Coche("Subaru", "XV", 5);
		coche1.mostrarDetalles();

		System.out.println();
		//Instanciacion del Objeto Moto
		Moto moto1 = new Moto("Harley-Davidson", "Sportster", "Negro");
		moto1.mostrarDetalles();
	}
}
