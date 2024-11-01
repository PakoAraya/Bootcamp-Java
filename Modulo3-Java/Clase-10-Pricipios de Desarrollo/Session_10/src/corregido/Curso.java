package corregido;

public class Curso {
	private String nombreCurso;
	private int totalHoras;

	public Curso(String nombreCurso, int totalHoras) {
		if (nombreCurso == null || nombreCurso.isEmpty()) {
			System.out.println("El nombre del curso no puede estar vacío");
		}
		this.nombreCurso = nombreCurso;
		this.totalHoras = totalHoras;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public int getTotalHorasCurso() {
		return totalHoras;
	}
}
