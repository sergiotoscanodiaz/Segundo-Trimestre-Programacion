package gestioncomerciosa;

public class Usuario extends Persona implements Cliente {

	private String telf;

	public void compra(Comercial comerc, Articulo art) {
		comerc.addSale(art);
	}
	
	public Usuario(String nombre, String correo, String telf) {
		super(nombre, correo);
		this.telf = telf;
	}
	
	public String getTelf() {
		return telf;
	}
	
	public void setTelf(String telf) {
		this.telf = telf;
	}
	
	@Override
	public String toString() {
		return String.format("Nombre: %s\nCorreo: %s\nTelefono: %s\n", nombre, correo, telf);
	}
	
}
