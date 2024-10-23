
function soyHumano() {
  if (checkbox.checked) {
    document.getElementById("parrafo-soyHumano").innerHTML = "Perfecto, haz reconocido que eres humano"
  } else {
    document.getElementById("parrafo-soyHumano").innerHTML = "Reconozco que soy un ser humano y no un bot.";
  }
}

function validarCorreo(correo) {
  let expReg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
  let esValido = expReg.test(correo);
  if (esValido == true) {
    alert("El correo electrónico es válido");
  } else {
    alert("El correo electrónico NO es válido");
  }
}

