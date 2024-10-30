package session1A;

public class Perro extends Animal{
	public String raza;


	Perro(String nombre,int edad,String raza){
		super(nombre,edad);//llama al constructor del padre
		this.raza=raza;
	}
	Perro(){
		super();//llama al constructor del padre
	}

	@Override
	public String toString() {
		return "Nombre: "+nombre + " Edad: "+edad+" Raza: "+raza;
	}

	@Override
	public void generarSonido() {
		System.out.println("el perro ladra");
	}
}