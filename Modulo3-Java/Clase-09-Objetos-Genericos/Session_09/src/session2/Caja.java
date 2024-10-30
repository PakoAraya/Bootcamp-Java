package session2;

//Se pueden declarar mas de 2 atributos genericos
public class Caja<T,U> {
	private T cotenido;
	public U valor;

	public Caja(T cotenido){
		this.cotenido = cotenido;
	}

	public T getCotenido(){
		return cotenido;
	}

	public void setContenido(T contenido){
		this.cotenido = contenido;
	}

	@Override
	public String toString() {
		return "Caja contiene: " + cotenido;
	}
}
