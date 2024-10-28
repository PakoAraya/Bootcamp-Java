package session_01;

//Ejercicio 3: Clase CuentaBancaria
//Crea una clase llamada CuentaBancaria con los siguientes atributos:
//• numeroCuenta (String)
//• saldo (double)
//• tipoCuenta (String)
//Requisitos:
//• Crea un constructor que reciba los atributos.
//• Crea un constructor que reciba los atributos sin el saldo.

public class Ejercicio3 {
	public static void main(String[] args){
		CuentaBancaria cuenta1 = new CuentaBancaria("00200",5000,"Corriente");
		System.out.println("Creacion de objeto con constructor completo: ");
		System.out.println("Numero de cuenta: " + cuenta1.numeroCuenta);
		System.out.println("Saldo de la cuenta: " + cuenta1.saldo);
		System.out.println("Tipo de cuenta: " + cuenta1.tipoCuenta);

		System.out.println("************************************************************************************");
		CuentaBancaria cuenta2 = new CuentaBancaria("00201","Vista");
		System.out.println("Creacion de objeto sin el parametro saldo: ");
		System.out.println("Numero de cuenta: " + cuenta2.numeroCuenta);
		System.out.println("Tipo de cuenta: " + cuenta2.tipoCuenta);
	}
}

class CuentaBancaria{
	//Declaracion de atributos
	String numeroCuenta;
	double saldo;
	String tipoCuenta;

	//Creacion de constructor con todos los atributos
	CuentaBancaria(String numeroCuenta, double saldo, String tipoCuenta){
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}

	//Creacion de segundo constructor sin parametro saldo
	CuentaBancaria(String numeroCuenta, String tipoCuenta){
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
	}

}
