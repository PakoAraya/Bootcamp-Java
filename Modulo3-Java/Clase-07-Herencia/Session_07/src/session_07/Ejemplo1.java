package session_07;

public class Ejemplo1 {
	public static void main(String[] args) {
		Perro perro1 = new Perro("Firulais", 8);
		System.out.println(perro1.nombre);
		System.out.println(perro1.edad);
		System.out.println(perro1.raza);

		perro1.generarSonido();  //Aqui esta sobreescribiendo
		perro1.generarSonidoPadre();    //Aqui llama directamente

	}
}
