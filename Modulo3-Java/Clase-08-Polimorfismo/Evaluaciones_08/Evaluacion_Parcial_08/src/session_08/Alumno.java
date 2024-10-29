package session_08;

class Alumno extends CursoMiembro {
	private Profesor profesor;
	private String hobby;

	public Alumno(String nombre, int identificador, Profesor profesor, String hobby) {
		super(nombre, identificador);
		this.profesor = profesor;
		this.hobby = hobby;
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
		System.out.println("Alumno: " + nombre + ", ID: " + identificador + ", Profesor: " + profesor.nombre + ", Hobby: " + hobby);
	}
}