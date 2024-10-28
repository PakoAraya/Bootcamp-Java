package session_04.ejercicio4;

public class CuentaBancaria {
	//Atributos de la clase
	public String titular;
	private String numeroCuenta;
	private double saldo;

	//Constructor vacio de la clase
	CuentaBancaria(){
	}

	//Constructor con parametros
	CuentaBancaria(String titular, String numeroCuenta, double saldo){
		this.titular = titular;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	//Setters y Getters de la clase
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular){
		this.titular = titular;
	}

	public String getNumeroCuenta(){
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta){
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo(){
		return saldo;
	}

	public void setSaldo(double saldo){
		if(saldo > 0){
			this.saldo = saldo;
		}else{
			this.saldo = 0;
		}
	}

	//Metodo depositar
	public void depositar(double cantidad){
		if(cantidad > 0){
			this.saldo += cantidad;
		}else{
			this.saldo += 0;
		}
	}

	//Metodo retirar
	public void retirar(double cantidad){
		if(cantidad > 0 && cantidad <= saldo){
			saldo -= cantidad;
		}else{
			saldo -= 0;
			System.out.println("No hay fondos");
		}
	}

	//Metodo toString
	@Override
	public String toString(){
		return "Cuenta Bancaria Numero: " + numeroCuenta + ", Titular: " + titular + ", saldo: " + saldo;
	}
}