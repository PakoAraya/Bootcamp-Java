package ejerciciosParte2;

public class MiClase {

	//Ejercicio1
	//Metodo obtenerIniciales usando Array
	public String obtenerIniciales(String nombreCompleto) {
		if(nombreCompleto == null || nombreCompleto.isEmpty()) {
			String mensaje = "No ha ingresdo un nombre...";
			return mensaje;
		}
		//return nombreCompleto;

		String[] nombres = nombreCompleto.split(" ");
		String resultado = "";
		for(String nombre : nombres) {
			if(!nombre.isEmpty()) {
				char inicial = nombre.toUpperCase().charAt(0);
				resultado += inicial+".";
			}
		}
		return resultado;

		// c.c.c.
	}

	//Ejercicio2 Obtener numero mayor de Array
	public int obtenerMayor(int[] numeros) {
		int mayor = numeros[0];
		for(int i=0; i < numeros.length; i++) {
			if(numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}

	//Ejercicio3 Obtener numeros pares dentro de un arreglo
	public int contarPares(int[] numeros) {
		int contador = 0;

		for (int i=0; i<numeros.length; i++) {
			if(numeros[i] % 2 == 0) {
				contador++;
			}
		}
		return contador;
	}

	//Ejercicio4 Validar numero de telefono (AssertTrue True/False)
	public boolean esNumeroTelefonoValido(String telefono) {
		if(telefono == null || telefono.length() != 10) {
			return false;
		}

		//Vamos a recorrer el arreglo que contiene el numero telefonico
		for(int i=0; i < telefono.length(); i++) {
			if(telefono.charAt(i) < '0' || telefono.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	//Ejercicio5 Validar cadena vacia
	public boolean esCadenaVacia(String cadena) {
		return cadena == null || cadena.isEmpty();
	}

	public static void main(String[] args) {
		//Instancias miClase para levantar metodos
		MiClase miClase = new MiClase();

		//Prueba de ejemplo1
		System.out.println("Iniciales de Alice Bob Carol: " + miClase.obtenerIniciales("alice bob carol"));

		//Prueba de ejemplo2
		int[] array1 = {3, 5, 9, 2};
		System.out.println("El numero mayor del arreglo es: " + miClase.obtenerMayor(array1));

		//Prueba de ejemplo3
		int[] array2 = {2, 3, 4, 6, 7};
		System.out.println("El arreglo tiene " + miClase.contarPares(array2) + " numeros pares");

		//Prueba de ejemplo4
		String telefono1 = "1234567890";
		System.out.println("Numero de telefono valido???: " + miClase.esNumeroTelefonoValido(telefono1));

		//Prueba de ejemplo5
		String cadena1 = "texto";
		System.out.println("La cadena viene vacia???: " + miClase.esCadenaVacia(cadena1));
	}
}
