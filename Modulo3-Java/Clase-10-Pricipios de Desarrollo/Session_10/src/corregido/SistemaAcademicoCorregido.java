package corregido;

public class SistemaAcademicoCorregido {
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("Juan");
		Curso curso = new Curso("Matematicas", 40);
		Registro registro = new Registro();

		registro.registrarEstudianteCurso(estudiante, curso);
		registro.calcularPromedioNotas(new int[]{85, 90, 78});
	}
}
