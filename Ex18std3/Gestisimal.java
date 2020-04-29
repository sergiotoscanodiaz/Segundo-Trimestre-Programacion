/* 
Modifica el programa Gestisimal realizado en clase con ArrayList (ejercicio 13 del capítulo 10)
añadiendo las siguientes mejoras:

a El listado de artículos debe aparecer ordenado alfabéticamente por el código de artículo.

b Al final del listado debe aparecer un resumen con los siguientes datos: número total de
artículos, precio de compra medio, precio de venta medio, margen de beneficio (precio de venta
menos precio de compra) medio.

c Añade al menú la opción “Listado de artículos bajos de stock” mediante la cual se obtiene un
listado con todos los datos de los artículos que tienen un stock inferior o igual a un número
(tope) que se introduce por teclado. Por ejemplo, si el usuario introduce el 20, aparecerán todos
los artículos con un stock inferior o igual a 20.
*/

package Ex18std3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Gestisimal {

  public static void main(String[] args) throws InterruptedException {
    Scanner read = new Scanner(System.in);

    int opcion;
    int primeraLibre;
    int i;
    int stockIntroducido;
    double precioDeCompraIntroducido;
    double precioDeVentaIntroducido;
    String codigo;
    String codigoIntroducido = "";
    String descripcionIntroducida;
    String precioDeCompraIntroducidoString;
    String precioDeVentaIntroducidoString;
    String stockIntroducidoString;
    boolean existeCodigo;

    //Crea el array de artículos
    ArrayList<Articulo> articulo = new ArrayList<>();
    
    articulo.add(new Articulo("A", "Lápiz", 1, 2, 30));
    articulo.add(new Articulo("B", "Rotulador", 2, 3, 30));
    articulo.add(new Articulo("C", "Goma", 2, 2, 60));
    articulo.add(new Articulo("D", "Regla", 4, 6, 21));
    articulo.add(new Articulo("E", "Libreta", 10, 15, 80));

    // Menu
    do {
      System.out.println("\n\nG E S T I S I M A L");
      System.out.println("===================");
      System.out.println("1. Listado");
      System.out.println("2. Alta");
      System.out.println("3. Baja");
      System.out.println("4. Modificación");
      System.out.println("5. Entrada de mercancía");
      System.out.println("6. Venta");
      System.out.println("7. Listado de artículos bajos de stock");
      System.out.println("8. Salir");
      System.out.print("Introduzca una opción: ");
      opcion = Integer.parseInt(read.nextLine());

      switch (opcion) {

        /////////////////////////////////////////////////////////////////////////////
        // LISTADO //////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        case 1:
          System.out.println("\nLISTADO");
          System.out.println("=======");
          
          int numeroArticulos = 0;
          double precioDeCompraTotal = 0;
          double precioDeVentaTotal = 0;
          Collections.sort(articulo);
          for (Articulo articulo1 : articulo) {
            System.out.println(articulo1);
            numeroArticulos++;
            precioDeCompraTotal += articulo1.getPrecioDeCompra();
            precioDeVentaTotal += articulo1.getPrecioDeVenta();
          }
          
          double precioDeCompraMedio = precioDeCompraTotal / numeroArticulos;
          double precioDeVentaMedio = precioDeVentaTotal / numeroArticulos;
          double margenBeneficioMedio = precioDeVentaMedio - precioDeCompraMedio;
          
          System.out.println("\nNúmero total de artículos: " + numeroArticulos);
          System.out.println("Precio de compra medio: " + String.format("%.2f", precioDeCompraMedio));
          System.out.println("Precio de venta medio: " + String.format("%.2f", precioDeVentaMedio));
          System.out.println("Margen de beneficio medio: " + String.format("%.2f", margenBeneficioMedio));
          

          break;

        /////////////////////////////////////////////////////////////////////////////
        // ALTA /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        case 2:
          System.out.println("\nNUEVO ARTÍCULO");
          System.out.println("==============");

          // Introducción de datos 
          System.out.println("Por favor, introduzca los datos del artículo.");
          System.out.print("Código: ");
          codigoIntroducido = read.nextLine();

          // Comprueba que el código introducido no se repita
          while (articulo.contains(new Articulo(codigoIntroducido))) {
            System.out.println("Ese código ya existe en la base de datos.");
            System.out.print("Introduzca otro código: ");
            codigoIntroducido = read.nextLine();
          }

          System.out.print("Descripcion: ");
          descripcionIntroducida = read.nextLine();

          System.out.print("Precio de compra: ");
          precioDeCompraIntroducido = Double.parseDouble(read.nextLine());

          System.out.print("Precio de venta: ");
          precioDeVentaIntroducido = Double.parseDouble(read.nextLine());

          System.out.print("Stock: ");
          stockIntroducido = Integer.parseInt(read.nextLine());

          articulo.add(new Articulo(codigoIntroducido, descripcionIntroducida, precioDeCompraIntroducido, precioDeVentaIntroducido, stockIntroducido));

          break;

        /////////////////////////////////////////////////////////////////////////////
        // BAJA /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        case 3:
          System.out.println("\nBAJA");
          System.out.println("====");

          System.out.print("Por favor, introduzca el código del artículo que desea dar de baja: ");
          codigoIntroducido = read.nextLine();

          if (!articulo.contains(new Articulo(codigoIntroducido))) {
            System.out.println("Lo siento, el código introducido no existe");
          } else {
            articulo.remove(new Articulo(codigoIntroducido));
            System.out.println("Artículo eliminado");
          }

          break;

        /////////////////////////////////////////////////////////////////////////////
        // MODIFICACIÓN /////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        case 4:
          System.out.println("\nMODIFICACIÓN");
          System.out.println("============");

          System.out.print("Por favor, introduzca el código del artículo cuyos datos desea cambiar: ");
          codigoIntroducido = read.nextLine();

          if (!articulo.contains(new Articulo(codigoIntroducido))) {
            System.out.println("El código introducido no existe.");
          } else {
            i = articulo.indexOf(new Articulo(codigoIntroducido));

            System.out.println("Introduzca los nuevos datos del artículo o INTRO para dejarlos igual.");

            System.out.println("Código: " + articulo.get(i).getCodigo());
            System.out.print("Nuevo código: ");
            codigoIntroducido = read.nextLine();
            if (!codigoIntroducido.equals("")) {
              articulo.get(i).setCodigo(codigoIntroducido);
            }

            System.out.println("Descripción: " + articulo.get(i).getDescripcion());
            System.out.print("Nueva descripción: ");
            descripcionIntroducida = read.nextLine();
            if (!descripcionIntroducida.equals("")) {
              articulo.get(i).setDescripcion(descripcionIntroducida);
            }

            System.out.println("Precio de compra: " + articulo.get(i).getPrecioDeCompra());
            System.out.print("Nuevo precio de compra: ");
            precioDeCompraIntroducidoString = read.nextLine();
            if (!precioDeCompraIntroducidoString.equals("")) {
              articulo.get(i).setPrecioDeCompra(Double.parseDouble(precioDeCompraIntroducidoString));
            }
            System.out.println("Precio de venta: " + articulo.get(i).getPrecioDeVenta());
            System.out.print("Nuevo precio de venta: ");
            precioDeVentaIntroducidoString = read.nextLine();
            if (!precioDeVentaIntroducidoString.equals("")) {
              articulo.get(i).setPrecioDeVenta(Double.parseDouble(precioDeVentaIntroducidoString));
            }
            System.out.println("Stock: " + articulo.get(i).getStock());
            System.out.print("Nuevo stock: ");
            stockIntroducidoString = read.nextLine();
            if (!stockIntroducidoString.equals("")) {
              articulo.get(i).setStock(Integer.parseInt(stockIntroducidoString));
            }
          }
          break;

        /////////////////////////////////////////////////////////////////////////////
        // ENTRADA DE MERCANCÍA /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        case 5:
          System.out.println("\nENTRADA DE MERCANCÍA");
          System.out.println("====================");

          System.out.print("Por favor, introduzca el código del artículo: ");
          codigoIntroducido = read.nextLine();

          i = articulo.indexOf(new Articulo(codigoIntroducido));

          if (!articulo.contains(new Articulo(codigoIntroducido))) {
            System.out.println("Lo siento, el código introducido no existe.");
          } else {
            System.out.println("Entrada de mercancía del siguiente artículo: ");
            System.out.println(articulo.get(i));
            System.out.print("Introduzca el número de unidades que entran al almacén: ");
            stockIntroducidoString = read.nextLine();
            articulo.get(i).setStock(Integer.parseInt(stockIntroducidoString) + articulo.get(i).getStock());
            System.out.println("La mercancía ha entrado en el almacén.");
          }

          break;

        /////////////////////////////////////////////////////////////////////////////
        // SALIDA DE MERCANCÍA //////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        case 6:
          System.out.println("\nVENTA");
          System.out.println("=====");

          System.out.print("Por favor, introduzca el código del artículo: ");
          codigoIntroducido = read.nextLine();

          i = articulo.indexOf(new Articulo(codigoIntroducido));

          if (!articulo.contains(new Articulo(codigoIntroducido))) {
            System.out.println("Lo siento, el código introducido no existe.");
          } else {
            System.out.println("Venta del siguiente artículo: ");
            System.out.println(articulo.get(i));
            System.out.print("Introduzca el número de unidades que desea vender: ");
            stockIntroducido = Integer.parseInt(read.nextLine());
            if (articulo.get(i).getStock() - stockIntroducido > 0) {
              articulo.get(i).setStock(articulo.get(i).getStock() - stockIntroducido);
              System.out.println("La venta ha sido realizada.");
              System.out.print("Generando factura");
              Thread.sleep(650); System.out.print(".");Thread.sleep(650); System.out.print(".");Thread.sleep(650); System.out.print(".");Thread.sleep(650); System.out.print(".");Thread.sleep(650); System.out.print(".");
              double precioSinIva = (articulo.get(i).getPrecioDeVenta()) * stockIntroducido;
              double iva = ((articulo.get(i).getPrecioDeVenta()) * (stockIntroducido)) * 0.21;
              System.out.println("\n\nFACTURA DE VENTA");
              System.out.println("================");
              System.out.println("Cod. Articulo: " + codigoIntroducido);
              System.out.println("Precio: " + String.format("%.2f", articulo.get(i).getPrecioDeVenta()) + "€");
              System.out.println("Cantidad: " + stockIntroducido);
              System.out.println("Precio sin IVA: " + String.format("%.2f", precioSinIva) + "€");
              System.out.println("IVA: " + String.format("%.2f", iva) + "€");
              System.out.println("----------------------");
              System.out.println("Precio Final: " + String.format("%.2f", (precioSinIva + iva)) + "€");
            } else {
              System.out.println("Lo siento, no se pueden sacar tantas unidades.");
            }
          }

          break;
        case 7:
          System.out.print("Introduce el stock máximo: ");
          int stockMaximo = Integer.parseInt(read.nextLine());
          
          System.out.println("LISTADO POR STOCK");
          System.out.println("=================");
          
          for (Articulo articulo1 : articulo) {
            if (articulo1.getStock() <= stockMaximo) {
              System.out.println(articulo1);
            }
          }
          break;
          
      } // switch
    } while (opcion != 8);
  }
}
