package puntos_extras;

public class Cliente {
	//Atributos de la clase
	private String nombre;
	private int edad;
	private Direccion direccion;

	//Constructor de la clase
	public Cliente(String nombre, int edad, Direccion direccion){
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
	}

	//Setters y Getters de los atributos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	//Metodos de la clase
	public double obtenerDescuentoPorEdad(){
		if(edad >= 65){
			System.out.print("Descuento Extra de 10% por tener 65 o más años \n");
			return 10;
		}else{
			return 0;
		}
	}

	@Override
	public String toString() {
		return nombre + "\nEdad: " + edad + "\nDirección: " + direccion.toString();
	}
}