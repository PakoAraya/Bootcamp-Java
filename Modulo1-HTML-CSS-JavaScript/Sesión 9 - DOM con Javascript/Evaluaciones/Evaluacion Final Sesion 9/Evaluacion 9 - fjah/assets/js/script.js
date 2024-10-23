var tareas = [
    { tarea: "Pintar la fachada de la casa" },
    { tarea: "Comprar comida para el perro" },
    { tarea: "Pagar la tarjeta de crédito" }
]

document.addEventListener('DOMContentLoaded', function() {
    // Referencias a los elementos
    const btnAgregarTarea = document.querySelector('.btn-success');
    const formulario = document.getElementById('formulario');
    const btnAgregar = document.querySelector('#formulario .btn-primary');
    const inputTarea = document.getElementById('nuevaTarea');
    const cuerpoTabla = document.getElementById('cuerpo-tabla');

    // Inicializa la tabla con las tareas existentes
    function cargarTareas() {
        cuerpoTabla.innerHTML = ''; // Limpia el contenido actual
        tareas.forEach(function(tarea, index) {
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${tarea.tarea}</td>
                <td><button type="button" class="btn btn-danger btn-sm" data-index="${index}">Finalizar</button></td>
            `;
            cuerpoTabla.appendChild(fila);
        });
    }

    // Muestra/oculta el formulario
    btnAgregarTarea.addEventListener('click', function() {
        if (formulario.style.display === 'none') {
            formulario.style.display = 'block';
        } else {
            formulario.style.display = 'none';
        }
    });

    // Agrega una nueva tarea
    btnAgregar.addEventListener('click', function() {
        const nuevaTarea = inputTarea.value.trim();
        if (nuevaTarea !== '') {
            tareas.push({ tarea: nuevaTarea });
            inputTarea.value = '';
            formulario.style.display = 'none'; // Oculta el formulario después de agregar
            cargarTareas(); // Actualiza la tabla
        }
    });

    // Maneja la eliminación de tareas
    cuerpoTabla.addEventListener('click', function(event) {
        if (event.target && event.target.matches('button.btn-danger')) {
            const index = event.target.getAttribute('data-index');
            tareas.splice(index, 1); // Elimina la tarea del arreglo
            cargarTareas(); // Actualiza la tabla
        }
    });

    // Carga las tareas iniciales
    cargarTareas();
});



