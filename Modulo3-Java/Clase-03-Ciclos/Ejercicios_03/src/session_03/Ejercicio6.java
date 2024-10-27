package session_03;

import java.util.Scanner;

//Escribe un programa que simule el proceso de una tienda en línea. El usuario
//ingresará los precios de 5 productos y se mostrará el total a pagar. Luego, si el
//total supera 100 unidades, se aplicará un descuento del 10% utilizando un
//operador de asignación.
public class Ejercicio6 {
  public static void main(String[] args) {
    int producto;
    float total=0, descuento = 0;
    Scanner scan = new Scanner(System.in);


    for(int i=1; i<6; i++) {
      System.out.println("Ingrese el precio del producto: " + i);
      producto = scan.nextInt();
      total += producto;
    }
    System.out.println("Total de productos a pagar: " + total);
    if (total > 100) {
      System.out.println("Aplica para descuento");
      descuento = total * 0.10f;
      total -= descuento;
    }
    System.out.println("El total con descuento es: " + total);
  }
}