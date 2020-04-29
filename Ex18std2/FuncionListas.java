/*
Crea una función que mezcla dos ArrayList de números enteros a partir de otros dos que se pasan
como parámetros. Para mezclarlos, se va cogiendo un elemento del primer ArrayList y otro del
segundo. Cuando se acaben los elementos de una de las listas lista, se continúan pasando los de la
otra.
*/

package Ex18std2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncionListas {

    public static void main(String[] args) {
      ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
      ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(77, 88, 99));
      ArrayList<Integer> lista3 = new ArrayList<>();

      System.out.println(mezclaListas(lista1, lista2));
      System.out.println(mezclaListas(lista2, lista1));
      System.out.println(mezclaListas(lista1, lista3));
      System.out.println(mezclaListas(lista2, lista3));
    }

    
   public static ArrayList<Integer> mezclaListas(ArrayList<Integer> a1, ArrayList<Integer> a2) {
     ArrayList<Integer> resultado = new ArrayList<>();
     
     int tamano1 = a1.size();
     int tamano2 = a2.size();
     int i = 0;
     
     do {
       if (i < tamano1) {
         resultado.add(a1.get(i));
       }

       if (i < tamano2) {
         resultado.add(a2.get(i));
       }

       i++;
     } while ((i < tamano1) || (i < tamano2));
     
     return resultado;
   }
}
