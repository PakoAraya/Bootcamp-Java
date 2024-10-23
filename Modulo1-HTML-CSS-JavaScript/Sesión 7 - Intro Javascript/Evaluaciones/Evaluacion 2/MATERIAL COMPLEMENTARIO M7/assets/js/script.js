let opcion = parseInt(prompt("¡Hola! Soy Eva, tu asistente virtual del Servicio al Cliente de Mentel. Estoy aquí para ayudarte en lo que necesides.\nEscribe el número de la opción que buscas: \n1.- Boletas y Pagos \n2.- Señal y llamadas \n3.- Oferta comercial  \n4.- Otras consultas"));
//FUNCIONES

if (opcion > 4) {
  alert("Ingrese una opción dentro del menú");
} else {
  switch (opcion) {
    case 1:
      let opcion1 = parseInt(prompt("Seleccione una opción: \n 1.- Ver Boleta \n 2.- Pagar Cuenta"));
      if (opcion1 == 1) {
        alert("Haga click aquí para descargar su boleta");
      } else {
        alert("Usted está siendo transferido. Espere por favor...");
      }
      break;
    case 2:
      let opcion2 = parseInt(prompt("Seleccione una opción: \n 1.- Problemas con la señal \n 2.- Problemas con las llamadas"));
      if (opcion2 == 1) {
        prompt("A continuación escriba su solicitud");
      } else {
        alert("Estimado usuario, su solicitud: 'Tengo problemas con la señal en avenida siempre viva', ha sido ingresada con éxito. Pronto será contactado por uno de nuestros ejecutivos");
      }
      break;
    case 3:
      let opcion3 = prompt("Mentel tiene una oferta comercial acorde a tus necesidades!. \n Para conocer más información y ser asesorado personalmente por un ejecutivo escribe 'SI'y un ejecutivo te llamará. De lo contrario ingrese 'NO'.");
      if (opcion3 == "si") {
        alert("Un ejecutivo contactará con usted");
      } else {
        alert("Gracias por preferir nuestros servicios");
      }
      break;
    case 4:
      let opcion4 = prompt("A continuación escriba su consulta.");
      if (opcion4 != "") {
        alert("Estimado usuario, su consulta: 'Quisiera saber por qué no ha llegado mi producto código 1234' Ha sido ingresada con éxito. Pronto sera contactado por uno de nuestros ejecutivos.");
      } else {
        alert("La opción ingresada no es válida. Gracias por preferir nuestros servicios");
      }
      break;
    default:
      alert("Opción Incorrecta");
  }
}


