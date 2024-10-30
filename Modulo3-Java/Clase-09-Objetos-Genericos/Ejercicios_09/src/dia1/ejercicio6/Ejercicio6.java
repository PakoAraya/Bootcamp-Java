package dia1.ejercicio6;

//Ejercicio 6:
//Creación y Comparación de Objetos con equals() y getClass()
//1. Crea una clase Empleado con atributos id y nombre.
//2. Sobreescribe equals() para comparar empleados solo si tienen el mismo id.
//3. En el main, crea dos empleados con el mismo id, usa equals() para verificar su
//igualdad y getClass() para verificar que son de la misma clase.

public class Ejercicio6 {
	public static void main(String[] args) {
		// Crear dos empleados con el mismo id pero nombres diferentes
		Empleado empleado1 = new Empleado(1, "Juan Perez");
		Empleado empleado2 = new Empleado(1, "Carlos Sanchez");

		//Comparar que los empleados tengas los mismos ID
		boolean empleadosIguales = empleado1.equals(empleado2);
		//Imprimiendo los resultados de la comparacion
		System.out.println("El ID de los empleados es igual = " + empleadosIguales);
	}
}
