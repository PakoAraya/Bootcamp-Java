package session_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      // Crear productos de ejemplo
      List<Producto> productos = new ArrayList<>();
      productos.add(new Vegetal("Zanahoria", "V01", 1000, "2024-10-01", "2024-10-31"));
      productos.add(new Vegetal("Papa", "V02", 500, "2024-10-05", "2024-11-05"));
      productos.add(new Vestuario("Camiseta", "C01", 15000, "M", "Azul"));
      productos.add(new Vestuario("Pantalón", "P01", 25000, "L", "Negro"));

      // Crear vendedor
      Vendedor vendedor = new Vendedor("Carlos Pérez", "12345678-9");
      Venta venta = new Venta(vendedor);

      boolean salir = false;
      while (!salir) {
          System.out.println("\n--- Menú de la Tienda ---");
          System.out.println("1. Listar productos");
          System.out.println("2. Agregar producto al carrito");
          System.out.println("3. Listar productos en el carrito");
          System.out.println("4. Pagar");
          System.out.println("5. Salir");
          System.out.print("Seleccione una opción: ");
          int opcion = scanner.nextInt();
          scanner.nextLine(); // Limpiar el buffer

          switch (opcion) {
              case 1:
                  System.out.println("Productos disponibles:");
                  for (Producto producto : productos) {
                      producto.mostrarDetalles();
                  }
                  break;
              case 2:
                  System.out.print("Ingrese el código del producto a agregar: ");
                  String codigo = scanner.nextLine();
                  Producto productoSeleccionado = productos.stream()
                      .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                      .findFirst()
                      .orElse(null);

                  if (productoSeleccionado != null) {
                      venta.agregarProducto(productoSeleccionado);
                  } else {
                      System.out.println("Producto no encontrado.");
                  }
                  break;
              case 3:
                  venta.listarCarrito();
                  break;
              case 4:
                  venta.pagar();
                  break;
              case 5:
                  salir = true;
                  break;
              default:
                  System.out.println("Opción no válida.");
          }
      }
      scanner.close();
  }
}