package dia1.ejercicio2;

public class Persona {
	//Atributos
	private String nombre;
	private int edad;

	//constructor de la clase
	public Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}

	//Setters y Getters
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

	//Metodo Equals (Sobreescritura)
	@Override
	public boolean equals(Object obj){
		//Comparacion para saber si vienen de la misma clase o tiene el mismo nombre
		if (obj.getClass() == getClass()) {
			//      if(this == obj) {
			//        System.out.println("Son objetos iguales");
			//      }else {
			//        System.out.println("No son objetos iguales");
			//      }

			//Casting de objetos
			Persona per = (Persona) obj;

			//comparando sus atributos
			if(this.nombre == per.nombre && this.edad == per.edad) {
				System.out.println("Son atributos iguales");
				return true;
			}else {
				System.out.println("No son atributos iguales");
				return false;
			}
		}else {
			System.out.println("NO son el mismo tipo de objeto");
		}
		return false;
	}

	//Metodo toString
	@Override
	public String toString(){
		return "Nombre: " + nombre + ", edad: " + edad;
	}
}