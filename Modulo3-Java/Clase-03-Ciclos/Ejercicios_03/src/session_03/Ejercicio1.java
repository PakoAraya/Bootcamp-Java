package session_03;

import java.util.Scanner;

//1. Escribe un programa que simule la actualización de una cuenta bancaria. El
//usuario ingresará un saldo inicial y se realizarán las siguientes operaciones
//utilizando operadores de asignación:
//▪ Se sumarán 100 unidades como depósito.
//▪ Se restarán 50 unidades como retiro.
//▪ Se multiplicará el saldo por un interés del 5%.

public class Ejercicio1 {
	public static void main(String[] args) {
		float saldoInicial, interes;
		//float saldoInteres;
		System.out.println("Ingrese monto: ");
		Scanner scan = new Scanner(System.in);
		
		saldoInicial = scan.nextInt();
		saldoInicial += 100;
		System.out.println("Saldo Inicial con ingreso de 100 es de: " + saldoInicial);
		saldoInicial -= 50;
		System.out.println("Saldo Inicial con retiro 50 es de: " + saldoInicial);
		interes = saldoInicial * 0.05f;
		saldoInicial += interes;
		System.out.println("Saldo Inicial con interes del 5% " + saldoInicial);
		
	}
}