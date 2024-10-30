package dia1.ejercicio5;

public class Libro {
	//Atributos de la clase
	private String titulo;
	private String autor;

	//Constructor de la clase
	public Libro(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
	}

	//Setters y Getters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	//Sobreescritura metodo toStrig
	@Override
	public String toString() {
		return "Título: " + titulo + ", Autor: " + autor;
	}

	//Sobreescribir el metodo equals
	@Override
	public boolean equals(Object obj){
		//Verificar si es el mismo objeto
		if (this == obj) {
			return true;
		}
		//Comprobar que no es de la misma clase
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}

		//Coversion del objeto a tipo libro
		Libro lib = (Libro) obj;

		//Comparando los atributos
		if (this.titulo == lib.titulo && this.autor == lib.autor){
			System.out.println("Son atributos iguales");
			return true;
		}else {
			System.out.println("No son atributos iguales");
			return false;
		}
		//Otra forma para comparar los atributos titulo y autor
		//return this.titulo.equals(otroLibro.titulo) && this.autor.equals(otroLibro.autor);

	}
}
