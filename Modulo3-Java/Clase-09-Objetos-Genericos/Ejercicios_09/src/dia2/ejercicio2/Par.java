package dia2.ejercicio2;

public class Par<T, U>{
	//Atributos de la clase
	private T primero;
	private U segundo;

	//Cosntructor de la clase
	public Par(T primero, U segundo){
		this.primero = primero;
		this.segundo = segundo;
	}

	//Metodo para devolver el primer valor
	public T getPrimero(){
		return primero;
	}

	public U getSegundo(){
		return segundo;
	}

	//Sobreescritura del metodo toString
	@Override
	public String toString(){
		return "El primer valor es: " + primero + ", y el segundo es: " + segundo;
	}
}
