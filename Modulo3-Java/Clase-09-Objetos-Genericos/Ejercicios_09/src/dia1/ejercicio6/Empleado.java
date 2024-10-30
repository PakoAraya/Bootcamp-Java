package dia1.ejercicio6;

public class Empleado {
	//Atributos de la clase
	private int id;
	private String nombre;

	//Constructor de la clase
	public Empleado(int id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}

	//Sobreescritura del metodo toString
	@Override
	public String toString(){
		return "Empleado ID: " + id + ", Nombre: " + nombre;
	}

	//Sobreescritura del metodo equals
	@Override
	public boolean equals (Object obj){
		//Verificar si es el mismo tipo de objeto
		if(this == obj){
			return true;
		}
		//Verificar si no viene vacio o si no es de la misma clase
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		//Convertir el objeto al tipo de objeto Empleado
		Empleado emp = (Empleado) obj;

		//Comparar si solo tienen el mismo ID
		if(this.id == emp.id){
			System.out.println("Son atributos iguales");
			return true;
		}else{
			System.out.println("NO son atributos iguales");
			return false;
		}
	}
}
