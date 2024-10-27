package session_01;

//En esta actividad, usted deberá crear la siguiente lista de compras:
//• Cocina $299990
//• Lavadora $ 234540
//• Comedor $159990
//• Televisor $345100
//Deberá calcular el total, el IVA (19%), el total más IVA (Impuesto al Valor Agregado) y
//finalmente el total en dólares (consulte el valor del dólar). La salida del programa será:
public class Drill1A {
public static void main(String[] args){
  float cocina = 299990;
  float lavadora = 234540;
  float comedor = 159990;
  float televisor = 345100;
  float suma, iva, total, total_dolares;

  suma = cocina + lavadora + comedor + televisor;
  iva = suma * 0.19f;
  total = suma + iva;
  total_dolares = total * 912;
  System.out.println("Aplicacion de calculo de compras");
  System.out.println("El total de los productos es: " + suma);
  System.out.println("El IVA es: " + iva);
  System.out.println("El total + IVA es: " + total);
  System.out.println("El total de la compra en dolares es: " + total_dolares);
}
}