package session_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Hoy veremos Collections

/*
map(): Transforma los elementos aplicando una función.
filter(): Selecciona elementos que cumplen una condición.
sorted(): Ordena los elementos en un stream.
distinct(): Elimina los duplicados en un stream.
 */
public class Ejemplo {
	public static void main(String[] args) {
		ArrayList<AlumnoSt> alumnos = new ArrayList<>();
		alumnos.add(new AlumnoSt("Juan", 5.5));
		alumnos.add(new AlumnoSt("Ana", 6.3));
		alumnos.add(new AlumnoSt("Pedro", 4.8));
		alumnos.add(new AlumnoSt("Maria", 6.9));

		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 3, 9, 2, 7);

		//filter stream()
		numeros.stream().filter(numero -> numero<6).forEach(System.out::println);
		/* Desglose de la anatomia
     numeros //Indicar la lista
     .stream() //stream()
     .filter(numero -> numero<6) //Aplicar operadores
     forEach(System.out::println); //Forma de mostrar al usuario los datos del list con numeros 
		 */

		//Desarrollando otro ejemplo de filter
		alumnos
		.stream()
		.filter(alumno -> alumno.calificacion <6.0)
		.forEach(System.out::println);

		//Y nos entrega un Array nuevo
		System.out.println(alumnos);

		//Ahora veremos MAP => Puede crear otro objeto en base a nuestras necesidades.
		//Permite tener una lista nueva con datos modificados
		//En este caso tendremos las nota de los alumnos con una modificacion.
		System.out.println("Notas alteradas");
		alumnos
		.stream()
		.map(alumno -> alumno.calificacion + 1.0)
		.forEach(System.out::println);
		System.out.println("Notas originales");
		System.out.println(alumnos);

		System.out.println("\n Otra forma de impresion con las Notas alteradas");
		alumnos
		.stream()
		.map(alumno -> new AlumnoSt(alumno.nombre, alumno.calificacion + 1.0))
		.forEach(System.out::println);
		System.out.println("Notas originales");
		System.out.println(alumnos);

		//Ahora imprimiremos solamente nombres
		System.out.println("\nSolo nombres");
		alumnos
		.stream()
		.map(alumno -> "Alumno: " + alumno.nombre)
		.forEach(System.out::println);

		//Obviamente se pueden aplicar tanto map y filter juntos de acuerdo a las necesidades que tengamos
		System.out.println("\n Impresion de datos con filter y map juntos...");
		alumnos
		.stream()
		.filter(alumno -> alumno.calificacion <6.0)
		.map(alumno -> alumno.calificacion + 1.0)
		.forEach(System.out::println);

		//Metodo SORT
		//Este metodo compara A con B (compara uno con otro), en este ejemplo ordenaremos de menor a mayor
		System.out.println("\nSORT");
		alumnos
		.stream()																//Cambiando el orden de los objetos cambia de desc a asc	 	
		//.sorted((alumnoA, alumnoB) -> Double.compare(alumnoB.calificacion, alumnoA.calificacion))
		.sorted((alumnoA, alumnoB) -> Double.compare(alumnoA.calificacion, alumnoB.calificacion))
		.forEach(System.out::println);

		//DISTINCT en Listas
		//Entrega numeros unicos (Sin duplicados)
		List<Integer> numerosD = Arrays.asList(1, 1, 1, 2, 4, 3, 5, 1);
		System.out.println("\nNumeros Unicos con Distinct");
		numerosD
		.stream()
		.distinct()
		.forEach(System.out::println);


		//Por supuesto que todos estos elementos se pueden mezclar entre si estas propiedades
		//Entrega numeros unicos (Sin duplicados)
		List<Integer> numerosE = Arrays.asList(1, 1, 1, 2, 4, 3, 5, 1);
		System.out.println("\nNumeros Unicos con Distinct, Solter y Filter");
		numerosD
		.stream()
		.distinct()
		.sorted((a,b) -> Integer.compare(a, b))
		.filter(numero -> numero >=3)
		.forEach(System.out::println);
	}
}


class AlumnoSt {
	String nombre;
	double calificacion;

	public AlumnoSt(String nombre, double calificacion) {
		this.nombre = nombre;
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return nombre + ": " + calificacion;

	}
}
