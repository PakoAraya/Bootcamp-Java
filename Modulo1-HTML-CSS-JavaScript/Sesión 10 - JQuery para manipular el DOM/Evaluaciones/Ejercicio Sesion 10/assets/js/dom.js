$(document).ready(function() {
    console.log('DOM cargado y listo');

    // Mostrar/ocultar el segundo div al pasar el mouse sobre el primero
    $('#text1').on('mouseover', function() {
        console.log('Mouseover en #text1');
        $('#text2').show();
    });

    $('#text1').on('mouseout', function() {
        console.log('Mouseout de #text1');
        $('#text2').hide();
    });

    // Agrandar la imagen al hacer clic y restaurar al tamaño original al salir
    $('#caja2').on('click', function() {
        console.log('Clic en #caja2');
        $('#img').css('width', '200%');
    });

    $('#caja2').on('mouseleave', function() {
        console.log('Mouseleave de #caja2');
        $('#img').css('width', '20%');
    });

    // Agrandar la letra al hacer doble clic
    $('#caja3 p').on('dblclick', function() {
        console.log('Doble clic en #caja3 p');
        $(this).css('font-size', '2em');
    });
});