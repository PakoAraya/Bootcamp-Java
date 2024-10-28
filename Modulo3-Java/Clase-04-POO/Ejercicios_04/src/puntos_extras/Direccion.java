package puntos_extras;

public class Direccion {
	private String calle;
	private String ciudad;
	private String pais;

	//Constructor de la clase
	public Direccion(String calle, String ciudad, String pais){
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	//Setters y Getters
	public String getCalle(){
		return calle;
	}

	public void setCalle(String calle){
		this.calle = calle;
	}

	public String getCiudad(){
		return ciudad;
	}
	public void setCiudad(String ciudad){
		this.ciudad = ciudad;
	}

	public String getPais(){
		return pais;
	}

	public void setPais(String pais){
		this.pais = pais;
	}

	//Metodo toString
	@Override
	public String toString(){
		return (calle + ", " + ciudad + ", " + pais);
	}
}
