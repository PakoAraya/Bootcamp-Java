package session2;

//* Hoy estudiaremos Genericos en Java
public class Main {
	public static void main(String[] args) {
		//Ejemplo 1 de instanciacion
		System.out.println("Generico");
		Caja<String, Object> cajaString = new Caja<>("paquete");
		System.out.println(cajaString.getCotenido());

		//Ejemplo 2 de instanciacion
		Caja<Integer, Object> cajaEntero = new Caja<>(24);
		System.out.println(cajaEntero.getCotenido());
	}
}
