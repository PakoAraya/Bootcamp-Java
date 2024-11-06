package session_13;

import java.util.*;

public class CentroEstudios {
	private List<Curso> cursos;
	private List<Alumno> alumnos;
	private Map<Curso, List<Alumno>> matriculas;

	public CentroEstudios() {
		cursos = new ArrayList<>();
		alumnos = new ArrayList<>();
		matriculas = new HashMap<>();
	}

	public void agregarCurso(Curso curso) {
		cursos.add(curso);
		matriculas.put(curso, new ArrayList<>());
	}

	public void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}

	public void asignarCursoAAlumno(String codigoCurso, String rutAlumno) {
		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Alumno alumno = buscarAlumnoPorRut(rutAlumno);

		if (curso != null && alumno != null) {
			matriculas.get(curso).add(alumno);
			System.out.println("Alumno asignado al curso.");
		} else {
			System.out.println("Curso o Alumno no encontrado.");
		}
	}

	public void mostrarCursos() {
		cursos.forEach(System.out::println);
	}

	public void verMatriculas() {
		matriculas.forEach((curso, alumnos) -> {
			System.out.println(curso + " - Alumnos inscritos: " + alumnos.size());
			alumnos.forEach(System.out::println);
		});
	}

	private Curso buscarCursoPorCodigo(String codigo) {
		return cursos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	private Alumno buscarAlumnoPorRut(String rut) {
		return alumnos.stream().filter(a -> a.getRut().equals(rut)).findFirst().orElse(null);
	}
}