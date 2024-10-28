package evaluacion;

public class Main {
	public static void main(String[] args) {
		// Crear 5 instancias de la clase Persona
		Persona p1 = new Persona("Ana", 22, 60.5, 1.65);
		Persona p2 = new Persona("Carlos", 17, 68.0, 1.75);
		Persona p3 = new Persona("Luisa", 30, 55.0, 1.60);
		Persona p4 = new Persona("Pedro", 15, 70.0, 1.80);
		Persona p5 = new Persona("Marta", 45, 80.0, 1.70);

		// Arreglo de personas
		Persona[] personas = {p1, p2, p3, p4, p5};

		// Evaluar IMC y mayor o menor de edad para cada persona
		for (Persona persona : personas) {
			System.out.println(persona.toString());
			double imc = persona.calcularIMC();
			System.out.printf("IMC: %.2f ", imc);
			if (imc < 18.5) {
				System.out.println("(Bajo peso)");
			} else if (imc >= 18.5 && imc < 24.9) {
				System.out.println("(Peso normal)");
			} else if (imc >= 25 && imc < 29.9) {
				System.out.println("(Sobrepeso)");
			} else {
				System.out.println("(Obesidad)");
			}

			// Verificar si es mayor o menor de edad
			if (persona.esMayorDeEdad()) {
				System.out.println("Es mayor de edad.");
			} else {
				System.out.println("Es menor de edad.");
			}
			System.out.println("------------------------");
		}
	}
}
