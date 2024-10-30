package session1B;

public class PooClass {

	public static void main(String[] args) {


		/*Calculadora cl1= new Calculadora(1);
        Calculadora cl2= new Calculadora(1);

        System.out.println(cl1.toString());
        System.out.println(cl2.toString());

        //equals boolean


        Perro perro1= new Perro("Nombre",12,"raza");

        //nombre de la clase
        System.out.println(perro1.getClass().getName());

        //nombre de la clase padre
        System.out.println(cl1.getClass().getSuperclass());


        System.out.println(cl1.equals(cl1));*/

		/*Perro perro1= new Perro("Nombre",12,"raza");

        System.out.println(perro1.getClass().getSimpleName());
        System.out.println(perro1.getClass().getSuperclass());

        Calculadora cl2= new Calculadora(1);

        System.out.println(cl2.getClass());
        System.out.println(cl2.getClass().getSuperclass());*/

		Calculadora cl1= new Calculadora(1);
		Calculadora cl2= new Calculadora(2);
		System.out.println(cl1.toString());
		System.out.println(cl2.toString());

		Perro perro1= new Perro("Nombre",12,"raza");

		System.out.println(cl1.equals(cl2)); 
	}
}