package session1A;

//* Hoy veremos elementos importantes de la clase Object

public class Ejemplo {
	public static void main(String[] args) {


		Calculadora cl1= new Calculadora(1); //A
		Calculadora cl2= new Calculadora(1); //B

		System.out.println(cl1.toString());
		System.out.println(cl2.toString());

		//cl1 es this.  => cl2 es obj o tambien
		// cl1 es A.    => cl2 es B

		//equals boolean


		Perro perro1= new Perro("Nombre",12,"raza");

		//nombre de la clase
		System.out.println(perro1.getClass().getName());

		//nombre de la clase padre
		System.out.println(perro1.getClass().getSuperclass());


		System.out.println(cl1.equals(cl1));
	}
}
