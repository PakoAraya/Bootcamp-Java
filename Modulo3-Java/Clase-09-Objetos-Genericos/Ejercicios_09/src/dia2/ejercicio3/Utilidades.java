package dia2.ejercicio3;

public class Utilidades {

	//El metodo tiene declarados atributos genericos y a traves de static puedo invocar el metodo
	//sin la necesidad de instanciar al objeto.
	public static <T>Boolean compararElementos(T elemento1, T elemento2){
		return elemento1.equals(elemento2);
	}
}
