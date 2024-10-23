
let numero1 = parseInt(prompt("Ingrese un número"));
let numero2 = parseInt(prompt("Ingrese otro número"));

if (numero1 > numero2) {
  alert("El numero 1: " + numero1 + " es mayor que numero 2: " + numero2);
} else if(numero2 > numero1) {
  alert("El numero 2: " + numero2 + " es mayor que numero 1: " + numero1);
} else {
  alert("Ambos números son iguales");
}

