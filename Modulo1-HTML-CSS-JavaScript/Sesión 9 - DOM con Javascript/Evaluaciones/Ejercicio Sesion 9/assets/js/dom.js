
// Obtener los elementos del DOM
const text1 = document.getElementById('text1');
const text2 = document.getElementById('text2');
const caja2 = document.getElementById('caja2');
const img = document.getElementById('img');
const caja3 = document.getElementById('caja3');

// Mostrar/ocultar el segundo div al pasar el mouse sobre el primero
text1.addEventListener('mouseover', () => {
    text2.style.display = 'block';
});

text1.addEventListener('mouseout', () => {
    text2.style.display = 'none';
});

// Agrandar la imagen al hacer clic y restaurar al tamaño original al salir
caja2.addEventListener('click', () => {
    img.style.width = '200%';
});

caja2.addEventListener('mouseout', () => {
    img.style.width = '20%';
});

// Agrandar la letra al hacer doble clic
caja3.addEventListener('dblclick', () => {
    caja3.style.fontSize = '2em';
});

