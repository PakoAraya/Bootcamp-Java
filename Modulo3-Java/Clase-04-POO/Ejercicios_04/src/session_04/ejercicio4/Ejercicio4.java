package session_04.ejercicio4;

//Ejercicio 4: Clase CuentaBancaria
//Enunciado:
//Crea una clase CuentaBancaria con los siguientes atributos:
//• Atributo público: titular (String)
//• Atributos privados: saldo (double), numeroCuenta (String)                        √

//Requisitos:
//1. Implementa los getters y setters con las siguientes validaciones:               √
//o El saldo debe ser mayor o igual a 0.

//2. Implementa los métodos depositar y retirar, que modifican el saldo según        √
//validaciones (no se puede retirar más del saldo disponible).

//3. Sobrecarga el metodo toString() para mostrar la información de la cuenta.       √

//4. Crea un constructor que inicialice todos los atributos.                         √

public class Ejercicio4 {
	public static void main(String[] args){
		//Objeto con constructor con parametros
		CuentaBancaria cuenta1 = new CuentaBancaria("Juan Donoso", "1000-0001", 50000.80);
		System.out.println(cuenta1.toString());

		System.out.println();
		//Usando el constructor vacio
		CuentaBancaria cuenta2 = new CuentaBancaria();
		//Cargo informacion usando accesadores
		cuenta2.setTitular("Monica Pavez");
		cuenta2.setNumeroCuenta("1000-002");
		cuenta2.setSaldo(35000.65);
		//Imprimiendo cuenta2
		System.out.println(cuenta2.toString());

		System.out.println();
		//Modificando cuenta2
		cuenta2.depositar(800);
		cuenta2.retirar(200);
		//Imprimiendo cuenta 2 con las modificaciones
		System.out.println(cuenta2.toString());

		System.out.println();
		cuenta2.retirar(40000.50);
		System.out.println(cuenta2.toString());

	}
}
