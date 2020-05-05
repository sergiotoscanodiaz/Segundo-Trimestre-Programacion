package gestioncomerciosa;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
	private Scanner s;
	private PrintStream salida;
	private CatalogoComercial catalogoComercial = new CatalogoComercial();
	private CatalogoUsuario catalogoUsuario = new CatalogoUsuario();
    	
 	// añade datos precargados
 	private void precarga() {
 		catalogoUsuario.put(new Usuario("Sergio", "sergio@github.com", "606-785-421"));
 		catalogoComercial.put(new Comercial("Alfredo", "alfredo@gmail.com", "comercial de ropa"));
    catalogoComercial.put(new Comercial("Ana", "ana@outlook.com", "comercial de papelería"));
    catalogoComercial.put(new Comercial("Francisco", "isco@hotmail.es", "comercial de bazar"));
    catalogoComercial.put(new Comercial("Mari", "mari@gmail.com", "comercial de informática"));
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
			catalogoUsuario.put(new Usuario(nombreCliente, correoCliente, tlfCliente));
		}
	}

	// funcion alta comercial
	private void altaComercial(String[] comando) {
		if (comando.length == 2) {
			// Modo interactivo
			String nombreComercial = scanLine("Nombre del comercial: ");
			String correoComercial = scanLine("Correo del comercial: ");
			String puestoComercial = scanLine("Puesto del comercial: ");
			catalogoComercial.put(new Comercial(nombreComercial, correoComercial, puestoComercial));
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
		for (String correo : catalogoUsuario.correos()) {
			System.out.println(catalogoUsuario.get(correo));
		}
		
	}

	// funcion lista comercial
	private void listarComercial(String[] comando) {
		for (String correo : catalogoComercial.correos()) {
			System.out.println(catalogoComercial.get(correo));
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
			catalogoUsuario.del(correoCliente);
		}
		
	}

	// Borra el comercial
	private void borrarComercial(String[] comando) {
		if (comando.length == 2) {

			String correoComercial = scanLine("Correo del comercial: ");
			catalogoComercial.del(correoComercial);
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
			Usuario usuario = catalogoUsuario.get(correoCliente);
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
				catalogoUsuario.del(correoCliente);
				catalogoUsuario.put(usuario);
				break;
			default:
				break;
			}
		} else if (comando.length == 5) {

			Usuario usuario = catalogoUsuario.get(comando[2]);
			if (usuario == null) {
				return;
			}
			switch (comando[3].toLowerCase()) {
			case "nombre":
				usuario.setNombre(comando[4].replaceAll("_", " "));
				break;
			case "telefono":
				usuario.setTelf(comando[4].replaceAll("_", "-"));
				break;
			case "correo":
				usuario.setCorreo(comando[4]);
				catalogoUsuario.del(comando[2]);
				catalogoUsuario.put(usuario);
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
			Comercial comercial = catalogoComercial.get(correoComercial);
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
				catalogoComercial.del(correoComercial);
				catalogoComercial.put(comercial);
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
 			if (catalogoComercial.get(correoComercial) == null) {
 				System.out.println("No existe ese comercial");
 				return;
 			}
 			String nombreProducto = scanLine("Introduce el nombre del producto: ");
 			String cantidad= scanLine("Introduce la cantidad a comprar: ");
 			int cantidadProducto = Integer.parseInt(cantidad);
 			Articulo art = new Articulo(nombreProducto, cantidadProducto);
 			Comercial comercial = catalogoComercial.get(correoComercial);
 			comercial.addSale(art);
 		} else if (comando.length == 4) {
 			int cantidad = Integer.parseInt(comando[3]);
 			Articulo art = new Articulo(comando[2].replaceAll("_", " "), cantidad);
 			Comercial comercial = catalogoComercial.get(comando[1]);
 			comercial.addSale(art);
 		}
 		
 	}
 	
 	// funcion principal
	public void ejecutar() {
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
