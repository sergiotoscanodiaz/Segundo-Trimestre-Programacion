
package Ex18std4;

public class Usuario extends Persona implements Cliente {
  // Atributos
  private String telefono;
  
  // Métodos
  public Usuario(String nombre, String correo, String telefono) {
    super(nombre, correo);
    this.telefono = telefono;
  }
  
}
