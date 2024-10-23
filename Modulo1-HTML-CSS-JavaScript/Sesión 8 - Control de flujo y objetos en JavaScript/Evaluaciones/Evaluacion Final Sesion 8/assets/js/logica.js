
//Vamos a crear arreglos de clients para tenerlos registrados.
const clientes = [
  //Cliente 1
  {nombre: 'John Connor', identificador: '1234', clave: 'abcd', saldo: 1000},
  //Cliente 2
  {nombre: 'Pablo Gómez', identificador: '5678', clave: 'efgh', saldo: 1500},
  //Cliente 3
  {nombre: 'José Luis Rodriguéz', identificador: '9101', clave: 'ijkl', saldo: 2000},
];

let clienteActual = null;

function iniciarSesion() {
  const identificador = prompt("Ingrese su identificador: ");
  const clave = prompt("Ingrese su clave: ");

  let clienteEncontrado = null;

  //Buscar al cliente dentro del arreglo
  for (let i=0; i<clientes.length; i++) {
    if (clientes[i].identificador === identificador) {
      clienteEncontrado = clientes[i];
      break;
    }
  }

  //Ahora verificar la clave de cliente encontrado
  if (clienteEncontrado && clienteEncontrado.clave === clave) {
    clienteActual = clienteEncontrado;
    alert(`Bienvenido ${clienteActual.nombre}`);
    mostrarMenu();
  } else {
    alert('Identificador o clave incorrectos.');
    iniciarSesion();
  }
}

//Funcion crear menu
function mostrarMenu() {
  let opcion;

  do {
    opcion = prompt(
      'Selecciona una opción: \n' + 
      '1. Ver saldo\n' + 
      '2. Realizar giro\n' + 
      '3. Realizar depósito\n' + 
      '4. Salir'
    );

    switch (opcion) {
      case '1':
        verSaldo();        
        break;
      case '2':
        realizarGiro();
        break;
      case '3':
        realizarDeposito();
        break;
      case '4':
        alert('Gracias por usar nuestros servicios');
        break;
      default:
        alert('Opción no válida. Intente de nuevo.');
    }
  } while (opcion !== '4');
}

//Creando la funcion ver saldo
function verSaldo() {
  alert(`Su saldo actual es: $${clienteActual.saldo}`);
}

//Creando la funcion realizar giro
function realizarGiro() {
  const monto = parseFloat(prompt('Ingrese el monto a girar: '));

  if (isNaN(monto) || monto<=0) {
    alert('Monto no válido');
    return;
  }

  if (monto > clienteActual.saldo) {
    alert('Monto Insuficiente.');
  } else {
    clienteActual.saldo -= monto;
    alert(`Giro realizado. Su nuevo saldo es: $${clienteActual.saldo}`);
  }
}

//Creando la funcion realizar deposito
function realizarDeposito() {
  const monto = parseFloat(prompt('Ingrese monto a depositar: '));

  if (isNaN(monto) || monto <= 0) {
    alert('Monto no válido.');
    return;
  }

  clienteActual.saldo += monto;
  alert(`Depósito realizado. Su nuevo saldo es: $${clienteActual.saldo}`);
}

//Para cargar el script desde el comienzo.
window.onload = iniciarSesion;