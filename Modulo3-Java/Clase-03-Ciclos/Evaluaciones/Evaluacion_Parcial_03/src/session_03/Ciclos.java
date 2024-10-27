package session_03;

import java.util.Scanner;

public class Ciclos {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		System.out.println("Ingrese una opcion para dibujar un diseno (1 o 2): ");
		opcion = scan.nextInt();
		
		switch (opcion) {
		case 1: 
			for (int i=0; i<3; i++) {
				System.out.println("* ");
			}
			System.out.println();
			for (int i=0; i<2; i++) {
				System.out.println(" .");
			}
		break;
		case 2:
			System.out.println("******");
			for (int i=0; i<4; i++) {
				System.out.println("*    *");
			}
			System.out.println("******");
			break;
		default:
			System.out.println("La opcion ingresada no es valida");;
			break;
		}
	}
}
