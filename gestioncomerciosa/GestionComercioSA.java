package gestioncomerciosa;

import java.util.Scanner;

public class GestionComercioSA {

	public static void main(String[] args) {

		Scanner s;
    s = new Scanner(System.in);
		Menu menu = new Menu(s, System.out);
		menu.ejecutar();
	}

}
