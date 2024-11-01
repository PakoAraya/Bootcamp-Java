package original;

public class SistemaAcademico {

	//Revisar codigo para que se aplique:
	//Modularizacion
	//DRY
	//KISS
	//YAGNI

	public String nombreEstudiante;
	public String nombreCurso;
	public int totalHorasCurso;

	public SistemaAcademico(String nombreEstudiante, String nombreCurso, int totalHorasCurso) {
		this.nombreEstudiante = nombreEstudiante;
		this.nombreCurso = nombreCurso;
		this.totalHorasCurso = totalHorasCurso;
	}

	public void registrarEstudiante(String nombreEstudiante) {

		if (nombreEstudiante == null || nombreEstudiante.isEmpty()) {
			System.out.println("El nombre del estudiante no puede estar vacío");
		} else {
			System.out.println("Estudiante registrado: " + nombreEstudiante);
		}
	}

	public void registrarCurso(String nombreCurso, int totalHorasCurso) {

		if (nombreCurso == null || nombreCurso.isEmpty()) {
			System.out.println("El nombre del curso no puede estar vacío");
		} else {
			System.out.println("Curso registrado: " + nombreCurso + " con " + totalHorasCurso + " horas");
		}
	}

	public void calcularPromedioNotas(int[] notas) {
		int suma = 0;
		for (int nota : notas) {
			suma += nota;
		}
		int promedio = suma / notas.length;
		System.out.println("Promedio de notas: " + promedio);
	}

	public void registrarEstudianteCurso() {

		registrarEstudiante(this.nombreEstudiante);
		registrarCurso(this.nombreCurso, this.totalHorasCurso);
		System.out.println("Estudiante " + this.nombreEstudiante + " registrado en el curso " + this.nombreCurso);
	}

	public void validarHorario() {

		System.out.println("Validando horario...");
	}

	public static void main(String[] args) {
		SistemaAcademico sistema = new SistemaAcademico("Juan", "Matemáticas", 40);
		sistema.registrarEstudianteCurso();
		sistema.calcularPromedioNotas(new int[]{85, 90, 78});
	}

}
