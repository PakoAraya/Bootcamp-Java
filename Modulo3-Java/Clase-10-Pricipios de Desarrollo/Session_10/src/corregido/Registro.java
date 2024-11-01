package corregido;

public class Registro {

	//Esta clase no tiene constructor porque no tiene atributos propios que necesiten instancias
	//o configuraciones (setters y getters) y solo ocupa elementos externos, por eso no necesita constructor.

	//Metodo Registrar a alumno en curso
	public void registrarEstudianteCurso(Estudiante estudiante, Curso curso) {
		System.out.println("Estudiante: " + estudiante.getNombreEstudiante() + " registrado en el curso: " + curso.getNombreCurso()
		+ " con un total de horas de: " + curso.getTotalHorasCurso());
	}

	//Metodo para calcular el promedio de notas
	public void calcularPromedioNotas(int[] notas) {
		int suma = 0;
		for (int nota : notas) {
			suma += nota;
		}
		int promedio = suma / notas.length;
		System.out.println("Promedio de notas: " + promedio);
	}
}
