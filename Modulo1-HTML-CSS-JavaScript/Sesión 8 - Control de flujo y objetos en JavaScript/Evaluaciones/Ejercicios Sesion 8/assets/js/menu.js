
// Función para mostrar el menú y manejar la selección del usuario
function mostrarMenu() {
  let opcion;
  do {
      // Mostrar el menú y capturar la opción del usuario
      opcion = prompt(
          "Menú:\n" +
          "1. Información general\n" +
          "2. Contacto\n" +
          "3. Servicios\n" +
          "4. Testimonios\n" +
          "5. Salir\n" +
          "Seleccione una opción (1-5):"
      );
      
      // Manejar la selección del usuario
      switch (opcion) {
          case '1':
              alert("Has seleccionado la Opción 1: Información general");
              break;
          case '2':
              alert("Has seleccionado la Opción 2: Contacto");
              break;
          case '3':
              alert("Has seleccionado la Opción 3: Servicios");
              break;
          case '4':
              alert("Has seleccionado la Opción 4: Testimonios");
              break;
          case '5':
              alert("Has seleccionado la Opción 5: Salir. Cerrando...");
              break;
          default:
              alert("Opción no válida. Por favor, seleccione una opción entre 1 y 5.");
              break;
      }
  } while (opcion !== '5'); // Continuar hasta que el usuario seleccione '5'
}

// Ejecutar la función cuando la página cargue
window.onload = mostrarMenu;


