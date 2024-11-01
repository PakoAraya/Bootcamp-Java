package corregido;

public class Estudiante {
	private String nombreEstudiante;

	public Estudiante(String nombreEstudiante) {
		if(nombreEstudiante == null || nombreEstudiante.isEmpty()) {
			System.out.println("El nombre del estudiante no puede estar vacío");
		}
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
}
