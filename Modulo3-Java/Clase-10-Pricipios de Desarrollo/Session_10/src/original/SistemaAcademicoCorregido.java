package original;
//generar una clase estudiante
// private nombreEstudiante
//*registrarEstudiante()

//generar un clase curso
//private nombreCurso
//*registrarCurso



public class SistemaAcademicoCorregido {

	//Modularización
	//DRY
	//KISS 
	//yagni 

	public String nombreEstudiante;
	public String nombreCurso;
	public int totalHorasCurso;

	public SistemaAcademicoCorregido(String nombreEstudiante, String nombreCurso, int totalHorasCurso) {
		this.nombreEstudiante = nombreEstudiante;
		this.nombreCurso = nombreCurso;
		this.totalHorasCurso = totalHorasCurso;
	}

	//mueve a Estudiante
	public void registrarEstudiante(String nombreEstudiante) {

		if (nombreEstudiante == null || nombreEstudiante.isEmpty()) {//funcion que valide nombre
			System.out.println("El nombre del estudiante no puede estar vacío");
		} else {
			System.out.println("Estudiante registrado: " + nombreEstudiante);
		}
	}
	//se mueve a curso
	public void registrarCurso(String nombreCurso, int totalHorasCurso) {//funcion que valide nombre

		if (nombreCurso == null || nombreCurso.isEmpty()) {
			System.out.println("El nombre del curso no puede estar vacío");
		} else {
			System.out.println("Curso registrado: " + nombreCurso + " con " + totalHorasCurso + " horas");
		}
	}

	//funcion fuera de la clase principal
	public void calcularPromedioNotas(int[] notas) {
		int suma = 0;
		for (int nota : notas) {
			suma += nota;
		}
		int promedio = suma / notas.length;
		System.out.println("Promedio de notas: " + promedio);
	}

	//dejar en una clase aparte
	public void registrarEstudianteCurso() {

		registrarEstudiante(this.nombreEstudiante);
		registrarCurso(this.nombreCurso, this.totalHorasCurso);
		System.out.println("Estudiante " + this.nombreEstudiante + " registrado en el curso " + this.nombreCurso);
	}

	//eliminar 
	public void validarHorario() {

		System.out.println("Validando horario...");
	}

	public static void main(String[] args) {
		SistemaAcademico sistema = new SistemaAcademico("Juan", "Matemáticas", 40);
		sistema.registrarEstudianteCurso();
		sistema.calcularPromedioNotas(new int[]{85, 90, 78});
	}

}

