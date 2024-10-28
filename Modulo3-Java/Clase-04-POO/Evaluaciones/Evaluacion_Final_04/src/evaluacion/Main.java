package evaluacion;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Solicitar los datos del auto desde la consola
		System.out.println("Ingrese la marca del auto:");
		String marca = scan.nextLine();
		System.out.println("Ingrese el modelo del auto:");
		String modelo = scan.nextLine();
		System.out.println("Ingrese el color del auto:");
		String color = scan.nextLine();
		System.out.println("Ingrese la velocidad máxima del auto:");
		int velocidadMaxima = scan.nextInt();

		//Crear el  objeto con los datos ingresados
		Auto miAuto = new Auto(marca, modelo,color, velocidadMaxima);

		//Menu de opciones
		int opcion;
		do {
			System.out.println("\n--- MENÚ ---");
			System.out.println("1. Encender el auto");
			System.out.println("2. Apagar el auto");
			System.out.println("3. Acelerar el auto");
			System.out.println("4. Mostrar datos del auto");
			System.out.println("5. Salir");
			System.out.print("Elija una opción: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				miAuto.encender();
				break;
			case 2:
				miAuto.apagar();
				break;
			case 3:
				miAuto.acelerar();
				break;
			case 4:
				miAuto.mostrarDatos();
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}
		} while (opcion != 5);
		scan.close();
	}
}
