/* 
Una empresa nos pide implementar la gestión de los comerciales y los clientes. El primer paso es
implementar las clases e interfaces con los métodos básicos. Crea la clase Comercial de tal forma
que de un comercial se conozca su nombre, correo electrónico, cargo que ocupa y los artículos que ha
vendido, es decir, una lista con los nombres de los artículos que ha vendido y la cantidad de cada uno
de ellos (crea una clase adicional Articulo con nombre y cantidad). La empresa tiene clientes que
pueden ser usuarios u otras empresas. Crea la clase Usuario. De cada usuario se quiere saber su
nombre, su correo electrónico y su teléfono. Crea la clase Empresa de tal forma que de cada una de
ellas se pueda saber su CIF, su nombre y su teléfono. Como los Comerciales y los usuarios son
personas, para no repetir innecesariamente código, crea la clase Persona como superclase abstracta
de Comercial y de Usuario con los atributos y métodos adecuados. Las clases Usuario y Empresa
deben implementar la interfaz Cliente que contiene el método compra().
*/

package Ex18std4;

public class Main {

  public static void main(String[] args) {
    Usuario pepe = new Usuario("Pepe", "pepe@yahoo.com", "555 123456");
    Usuario pablo = new Usuario("Pablo", "pablo@gmail.com", "555 112233");
    Empresa ofiMalaga = new Empresa("B123456", "Ofi Málaga", "555 654321");
    Comercial juan = new Comercial("Juan", "juan@hotmail.com", "jefe de ventas");
    Comercial luis = new Comercial("Luis", "luis@gmail.com", "coordinador de ventas");
    pepe.compra(juan, new Articulo("Impresora Láser", 1));
    ofiMalaga.compra(juan, new Articulo("Impresora Láser", 2));
    pepe.compra(juan, new Articulo("Paquete de folios", 10));
    pablo.compra(luis, new Articulo("Clasificador anillas", 12));
    pepe.compra(luis, new Articulo("Paquete de folios", 50));
    pablo.compra(luis, new Articulo("Mesa escritorio", 6));
    pepe.compra(juan, new Articulo("Paquete de folios", 5));
    System.out.println(juan);
    System.out.println(luis);
  }
  
}
