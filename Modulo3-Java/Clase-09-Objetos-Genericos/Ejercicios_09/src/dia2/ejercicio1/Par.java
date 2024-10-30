package dia2.ejercicio1;

public class Par<T,U> {
	private T primero;
	private U segundo;

	public Par(T primero, U segundo){
		this.primero = primero;
		this.segundo = segundo;
	}

	public T getPrimero(){
		return primero;
	}

	public U getSegundo(){
		return segundo;
	}

	//Metodo tostring
	@Override
	public String toString(){
		return "Par de datos, el primero: " + primero + ", y el segundo: " + segundo;
	}
}
