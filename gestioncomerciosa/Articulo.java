package gestioncomerciosa;

public class Articulo {
	private String art;
	private int cant;
	
	public Articulo(String art, int cant) {
		this.art = art;
		this.cant = cant;
	}
	
	public void addCant(int cant) {
		this.cant += cant;
	}

	public String getArt() {
		return art;
	}

	public int getCant() {
		return cant;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %d unid.", art, cant);
	}
}
