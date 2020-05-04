package gestioncomerciosa;

import java.util.HashMap;
import java.util.Set;

public class CatalogoUsuario {

	private HashMap<String, Usuario> mapa = new HashMap<>();
	
	public void put(Usuario usuario) {
		String correo = usuario.getCorreo();
		mapa.put(correo, usuario);
	}
	
	public Usuario get(String correo) {
		return mapa.get(correo);
	}
	
	public void del(String correo) {
		mapa.remove(correo);
	}

	public Set<String> correos(){
		return mapa.keySet();
	}
}
