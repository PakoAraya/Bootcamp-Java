package session_08;

class Profesor extends CursoMiembro {
	private String especialidad;

	public Profesor(String nombre, int identificador, String especialidad) {
		super(nombre, identificador);
		this.especialidad = especialidad;
	}

	@Override
	public void leer() {
		System.out.println(nombre + " está leyendo.");
	}

	@Override
	public void realizarEjercicios() {
		System.out.println(nombre + " está realizando ejercicios en clase.");
	}

	@Override
	public void mostrarDatos() {
		System.out.println("Profesor: " + nombre + ", ID: " + identificador + ", Especialidad: " + especialidad);
	}
}