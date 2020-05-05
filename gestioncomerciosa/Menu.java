package gestioncomerciosa;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

  private Scanner s;
  private PrintStream salida;
  private ListaComercial listaComercial = new ListaComercial();
  private ListaCliente listaCliente = new ListaCliente();

  // añade datos precargados
  private void precarga() {
    listaCliente.put(new Usuario("Sergio", "sergio@github.com", "606-785-421"));
    listaComercial.put(new Comercial("Alfredo", "alfredo@gmail.com", "comercial de ropa"));
    listaComercial.put(new Comercial("Ana", "ana@outlook.com", "comercial de papelería"));
    listaComercial.put(new Comercial("Francisco", "isco@hotmail.es", "comercial de bazar"));
    listaComercial.put(new Comercial("Mari", "mari@gmail.com", "comercial de informática"));
  }

  // funcion para imprimir la lista de comandos
  public void comandos() {
    System.out.println("Menú principal, ¿Qué desea hacer?:");
    System.out.println("listar (comercial o cliente)");
    System.out.println("alta (comercial o cliente)");
    System.out.println("borrar (comercial o cliente)");
    System.out.println("modifica (comercial o cliente)");
    System.out.println("compra");
    System.out.println("salir - Sale del programa");
  }

  public Menu(Scanner s, PrintStream salida) {
    this.s = s;
    this.salida = salida;
  }

  // Funcion scanLine para separar comandos
  private String[] scan(String prompt) {
    return scanLine(prompt).split(" ");
  }

  // Lee toda la linea de la entrada
  private String scanLine(String prompt) {
    System.out.print(prompt);
    return s.nextLine();
  }

  // funcion que comprueba que los parámetros sean los correctos
  private boolean comprobarComandos(String[] comando) {
    if (comando.length < 2) {
      return false;
    }
    return comando[1].equals("comercial") || comando[1].equals("cliente");
  }

  // funcion de alta 
  private void alta(String[] comando) {
    if (!comprobarComandos(comando)) {
      System.out.println("Debes pasar como parametro \"comercial\" o \"cliente\"");
      return;
    }
    if (comando[1].equals("comercial")) {
      altaComercial(comando);
    } else {
      altaCliente(comando);
    }
  }

  // funciona alta cliente
  private void altaCliente(String[] comando) {
    if (comando.length == 2) {
      // Modo interactivo
      String nombreCliente = scanLine("Nombre del cliente: ");
      String correoCliente = scanLine("Correo del cliente: ");
      String tlfCliente = scanLine("Telefono del cliente: ");
      listaCliente.put(new Usuario(nombreCliente, correoCliente, tlfCliente));
    }
  }

  // funcion alta comercial
  private void altaComercial(String[] comando) {
    if (comando.length == 2) {
      // Modo interactivo
      String nombreComercial = scanLine("Nombre del comercial: ");
      String correoComercial = scanLine("Correo del comercial: ");
      String puestoComercial = scanLine("Puesto del comercial: ");
      listaComercial.put(new Comercial(nombreComercial, correoComercial, puestoComercial));
    }
  }

  // funcion de lista
  private void listar(String[] comando) {
    if (!comprobarComandos(comando)) {
      System.out.println("Debes pasar como parametro \"comercial\" o \"cliente\"");
      return;
    }
    if (comando[1].equals("comercial")) {
      listarComercial(comando);
    } else {
      listarCliente(comando);
    }
  }

  // funcion lista cliente
  private void listarCliente(String[] comando) {
    for (String correo : listaCliente.correos()) {
      System.out.println(listaCliente.get(correo));
    }

  }

  // funcion lista comercial
  private void listarComercial(String[] comando) {
    for (String correo : listaComercial.correos()) {
      System.out.println(listaComercial.get(correo));
    }
  }

  // Funcion de borrado
  private void borrar(String[] comando) {
    if (!comprobarComandos(comando)) {
      System.out.println("Debes pasar como parametro \"comercial\" o \"cliente\"");
      return;
    }
    if (comando[1].equals("comercial")) {
      borrarComercial(comando);
    } else {
      borrarCliente(comando);
    }
  }

  // Borra el cliente
  private void borrarCliente(String[] comando) {
    if (comando.length == 2) {

      String correoCliente = scanLine("Correo del cliente: ");
      listaCliente.del(correoCliente);
    }

  }

  // Borra el comercial
  private void borrarComercial(String[] comando) {
    if (comando.length == 2) {

      String correoComercial = scanLine("Correo del comercial: ");
      listaComercial.del(correoComercial);
    }
  }

  // funcion de modificación
  private void modificar(String[] comando) {
    if (!comprobarComandos(comando)) {
      System.out.println("Debes pasar como parametro \"comercial\" o \"cliente\"");
      return;
    }
    if (comando[1].equals("comercial")) {
      modificarComercial(comando);
    } else {
      modificarCliente(comando);
    }
  }

  // funcion modificacion cliente
  private void modificarCliente(String[] comando) {
    if (comando.length == 2) {

      String correoCliente = scanLine("Correo del cliente: ");
      String nombreCampo = scanLine("Nombre del campo a modificar: ");
      String valorCampo = scanLine("Nuevo valor del campo: ");
      Usuario usuario = listaCliente.get(correoCliente);
      if (usuario == null) {
        System.out.println("No existe ese comercial");
        return;
      }
      switch (nombreCampo.toLowerCase()) {
        case "nombre":
          usuario.setNombre(valorCampo);
          break;
        case "telefono":
          usuario.setTelf(valorCampo);
          break;
        case "correo":
          usuario.setCorreo(valorCampo);
          listaCliente.del(correoCliente);
          listaCliente.put(usuario);
          break;
        default:
          break;
      }
    }

  }

  // funcion modificacion comercial
  private void modificarComercial(String[] comando) {
    if (comando.length == 2) {

      String correoComercial = scanLine("Correo del comercial: ");
      String nombreCampo = scanLine("Nombre del campo a modificar: ");
      String valorCampo = scanLine("Nuevo valor del campo: ");
      Comercial comercial = listaComercial.get(correoComercial);
      if (comercial == null) {
        System.out.println("No existe ese comercial");
        return;
      }
      switch (nombreCampo.toLowerCase()) {
        case "nombre":
          comercial.setNombre(valorCampo);
          break;
        case "cargo":
          comercial.setPuesto(valorCampo);
          break;
        case "correo":
          comercial.setCorreo(valorCampo);
          listaComercial.del(correoComercial);
          listaComercial.put(comercial);
          break;
        default:
          break;
      }
    }
  }

  //función compra
  private void compra(String[] comando) {
    if (comando.length < 1) {
      return;
    }
    if (comando.length == 1) {
      String correoComercial = scanLine("Introduce el correo del comercial: ");
      if (listaComercial.get(correoComercial) == null) {
        System.out.println("No existe ese comercial");
        return;
      }
      String nombreProducto = scanLine("Introduce el nombre del producto: ");
      String cantidad = scanLine("Introduce la cantidad a comprar: ");
      int cantidadProducto = Integer.parseInt(cantidad);
      Articulo art = new Articulo(nombreProducto, cantidadProducto);
      Comercial comercial = listaComercial.get(correoComercial);
      comercial.addSale(art);
    } else if (comando.length == 4) {
      int cantidad = Integer.parseInt(comando[3]);
      Articulo art = new Articulo(comando[2].replaceAll("_", " "), cantidad);
      Comercial comercial = listaComercial.get(comando[1]);
      comercial.addSale(art);
    }

  }

  // funcion principal
  public void empezar() {
    precarga();
    comandos();
    while (true) {
      String[] comando = scan("Escribe aquí: ");
      switch (comando[0]) {
        case "salir":
          return;
        case "alta":
          alta(comando);
          break;
        case "listar":
          listar(comando);
          break;
        case "borrar":
          borrar(comando);
          break;
        case "modifica":
          modificar(comando);
          break;
        case "compra":
          compra(comando);
          break;
        case "comandos":
          comandos();
          break;

        default:
          System.out.println("Comando no reconocido\n");
          comandos();
      }
    }
  }

}
