/* 
Realiza un test de inglés. La información se debe almacenar en un diccionario (HashMap) en el que
las entradas (al menos 8) están formadas por pares (palabra en inglés, palabra en español). El
programa hará 5 preguntas. No es necesario controlar que no se repitan las preguntas. En cada
pregunta elegirá al azar una palabra en inglés y otra en español y preguntará si es correcto.
*/

package Ex18std1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    
    HashMap<String,String> diccionario = new HashMap<>();
    ArrayList<String> ingles = new ArrayList<>();
    ArrayList<String> espanol = new ArrayList<>();
    
    int respuestasAcertadas = 0;
    int respuestasIncorrectas = 0;
    int aleatorio;
    String respuesta;
    String inglesString = "";
    String espanolString = "";
    
    diccionario.put("raspberry", "frambuesa");
    diccionario.put("house", "casa");
    diccionario.put("apple", "manzana");
    diccionario.put("green", "verde");
    diccionario.put("water", "agua");
    diccionario.put("ball", "pelota");
    diccionario.put("dog", "perro");
    diccionario.put("tall", "alto");
    
    ingles.add("raspberry");
    espanol.add("frambuesa");
    ingles.add("house");
    espanol.add("casa");
    ingles.add("apple");
    espanol.add("manzana");
    ingles.add("green");
    espanol.add("verde");
    ingles.add("water");
    espanol.add("agua");
    ingles.add("ball");
    espanol.add("pelota");
    ingles.add("dog");
    espanol.add("perro");
    ingles.add("tall");
    espanol.add("alto");
        
    for (int i = 0; i < 5; i++) {
      System.out.print("¿");
      aleatorio = (int)(Math.random() * ingles.size());
      inglesString = ingles.get(aleatorio);
      System.out.print(inglesString + " es ");
      aleatorio = (int)(Math.random() * espanol.size());
      espanolString = espanol.get(aleatorio);
      System.out.print(espanolString + "? Conteste (s/n): ");
      respuesta = read.nextLine();
      
      if (((diccionario.get(inglesString) == espanolString) && (respuesta.equals("s"))) || ((diccionario.get(inglesString) != espanolString) && (respuesta.equals("n")))) {
        respuestasAcertadas++;
      }
      
    }
     System.out.println("Respuestas acertadas: " + respuestasAcertadas);  
  }
  
}
