package dia3.ejercicio1;

/**
 * @author  : Francisco Javier Araya
 * @version : 0.0.1
 * @since   : 11-10-2024
 */

public class Utilidades {
	// Metodo genérico para comparar el consumo de dos electrodomésticos
	public static <T> T elementoDeMenorConsumo(T obj1, T obj2) {
		// Verificar si ambos objetos son instancias de Electrodomestico o subclases
		if (obj1 instanceof Electrodomestico && obj2 instanceof Electrodomestico) {
			// Convertir los objetos a tipo Electrodomestico
			Electrodomestico e1 = (Electrodomestico) obj1;
			Electrodomestico e2 = (Electrodomestico) obj2;

			// Comparar el consumo y devolver el de menor consumo usando if y else
			Electrodomestico menorConsumo;
			if (e1.getConsumo() < e2.getConsumo()) {
				menorConsumo = e1;
				System.out.println("El objeto de menor consumo es: " + e1.toString());
			} else {
				menorConsumo = e2;
				System.out.println("El objeto de menor consumo es: " + e2.toString());
			}
			//Mismo codigo del if pero optimizado
			//Electrodomestico menorConsumo = (e1.getConsumo() < e2.getConsumo()) ? e1 : e2;

			// Devolver el objeto con menor consumo
			return (T) menorConsumo;
		} else {
			//throw new IllegalArgumentException("Ambos objetos deben ser de tipo Electrodomestico o sus subclases.");
			// Mensaje alternativo si los objetos no son del tipo esperado
			System.out.println("Ambos objetos deben ser de tipo Electrodomestico o sus subclases.");
			return null;  // Retorna null si no son del tipo esperado
		}
	}
}

/*
Otra Forma de Aplicacion mas sencilla

 public class Utilidades {

	public static <T> String elementoDeMenorConsumo(T obj1, T obj2) {
		System.out.println("aja");
        if (obj1 instanceof Electrodomestico && obj2 instanceof Electrodomestico) {
            Electrodomestico electro1 = (Electrodomestico) obj1;
            Electrodomestico electro2 = (Electrodomestico) obj2;

            if(electro1.getConsumo()<electro2.getConsumo()) {
               	String mensaje ="El ob de menor consumo es: " + obj1.toString();
            	System.out.println(mensaje);
            	return mensaje;

            } else {
            	String mensaje = "El obj de menor consumo es: " + obj2.toString();
            	System.out.println(mensaje);
            	return mensaje;

            }
        } else {
	    	System.out.println("No es de la misma clase");
	    }
        return "";
	}

}

 */
