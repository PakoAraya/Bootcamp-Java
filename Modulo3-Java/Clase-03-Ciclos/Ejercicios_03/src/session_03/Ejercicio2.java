package session_03;
//Escribe un programa que imprima los días de la semana en orden. Usa un
//ciclo for para recorrer un arreglo que contiene los días de l
//String[] dias = {"Lunes" , "Martes" , "Miércoles" , "Jueves" , "Viernes" , "Sábado" ,
//"Domingo"};

public class Ejercicio2 {
  public static void main(String[] args) {
    String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

    for (int i = 0; i < dias.length; i++) {
      System.out.println("Dia: " + dias[i]);
    }
  }
}
