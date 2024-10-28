package puntos_extras;

public class Categoria {
	//Atributos de la clase
	private String nombreCategoria;
	private double descuento;

	//Constructor de la clase
	public Categoria(String nombreCategoria, double descuento){
		this.nombreCategoria = nombreCategoria;
		this.descuento = descuento;
	}

	//Setters y Getters de la clase
	public String getNombreCategoria(){
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria){
		this.nombreCategoria = nombreCategoria;
	}

	public double getDescuento(){
		return descuento;
	}

	public void setDescuento(double descuento){
		this.descuento = descuento;
	}

	//Metodo toString
	@Override
	public String toString(){
		return (nombreCategoria + ", descuento: " + descuento + "%");
	}
}
