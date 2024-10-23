$(document).ready(function() {
  // Manejar el clic en "Ver más"
  $(".text-body-secondary").click(function() {
      // Obtener el ID del destino basado en el ID del botón cliqueado
      var idDestino = $(this).attr("id");
      
      // Ocultar todos los detalles
      $(".detalles").hide();
      
      // Mostrar el detalle del destino cliqueado
      $("#detalles" + idDestino).show();
  });

  // Manejar el clic en el botón de cierre
  $(".btn-close").click(function() {
      // Ocultar el recuadro específico al que pertenece el botón de cierre
      $(this).closest(".detalles").hide();
  });
});