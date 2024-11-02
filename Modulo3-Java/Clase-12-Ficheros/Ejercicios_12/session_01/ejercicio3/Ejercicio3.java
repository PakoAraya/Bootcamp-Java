package session_01.ejercicio3;

//Ejercicio 3: Leer Productos y Precios, Guardarlos en Dos ArrayList, y Calcular el Total
//• Descripción: Crea un archivo productos.txt que contenga productos y precios
//separados por comas, en formato Producto,Precio. El programa debe leer los
//datos del archivo, almacenar los nombres en un ArrayList<String>, los precios
//en un ArrayList<Double>, y calcular el total de los precios.
//• Instrucciones:
//1. Escribe un programa en Java que:
//▪ Lea cada línea, utilice el metodo split() para separar el nombre
//del producto y el precio.
//▪ Guarde los nombres en un ArrayList<String> y los precios en un
//ArrayList<Double>.
//▪ Calcule la suma de los precios y muestre el total junto con la
//lista de productos y precios en consola.
//• Investigación: Investiga cómo utilizar split(",") para dividir una línea de texto
//con comas como delimitadores, de modo que puedas separar el producto del
//precio en este ejercicio.

//Manzana,1.50
//Palta,0.75
//Pan,2.00
//Leche,1.25
//Queso,3.50

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Ejercicio3 {
	public static void main(String[] args) {
		//Crear la ruta de acceso del documento.
		String rutaArchivo = "/Users/pako/Documents/GitHub/Bootcamp-Java/Modulo3-Java/Clase-12-Ficheros/Session_12/src/session_01/ejercicio3/productos.txt";

		//Declaracion de los Arraylist
		ArrayList<String> productos = new ArrayList<>();
		ArrayList<Double> precios = new ArrayList<>();

		//Try catch para manjer
		try{
			FileReader fr = new FileReader(rutaArchivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null){
				//Usamos split(",") para separar el producto del precio
				String[] datos = linea.split(",");
				//Los substrings que obtenermos, debemos almacenarlos segun tipo de dato.
				//       0          1
				//   [Manzana] , [1.50]
				String producto = datos[0]; //Nombre del producto
				double precio =  Double.parseDouble(datos[1]); //Precio del producto

				//Ahora se deben agregar a los Arraylist con el evento add.
				productos.add(producto);
				precios.add(precio);

			}
		} catch (IOException e) {
			//throw new RuntimeException(e);
			System.out.println("Error al intentar abrir el archivo...");
		}
		//Ahora hay que calcular el precio total del Arraylist
		double total = 0;
		for(double precio : precios){
			total += precio;
		}
		//Mostrar todos los datos, nombre de los productos y sus precios.
		for (int i=0; i < productos.size(); i++) {
			System.out.println("Producto: " + productos.get(i) + " $" + precios.get(i));
		}
		System.out.println("El total de los precios de los productos es: " + total);
	}
}

