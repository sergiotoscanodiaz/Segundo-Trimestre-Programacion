package gestioncomerciosa;

public class Empresa implements Cliente {

	private String cif;
	private String nombre;
	private String telf;
	@Override
	public void compra(Comercial comerc, Articulo art) {
		comerc.addSale(art);
	}
	
	public Empresa(String cif, String nombre, String telf) {
		this.cif = cif;
		this.nombre = nombre;
		this.telf = telf;
	}
	
}
