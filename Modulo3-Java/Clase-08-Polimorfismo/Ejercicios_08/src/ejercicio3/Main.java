package ejercicio3;

//Ejercicio 4: Animales y Sonidos
//Crea una clase Animal con un metodo emitirSonido(). Luego, crea tres clases hijas
//Gato, Perro y Vaca, cada una sobrescribiendo el metodo emitirSonido() para imprimir
//un sonido específico:
//• Gato imprime "Miau".
//• Perro imprime "Guau".
//• Vaca imprime "Muuu".

public class Main {
	public static void main(String[] args) {
		//Creando objetos para cada clase
		Gato gato = new Gato();
		Perro perro = new Perro();
		Vaca vaca = new Vaca();

		//Llamado a metodos de emitir sonidos
		gato.emitirSonido();
		perro.emitirSonido();
		vaca.emitirSonido();
	}
}
