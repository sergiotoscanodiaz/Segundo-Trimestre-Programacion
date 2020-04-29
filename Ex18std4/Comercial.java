
package Ex18std4;

public class Comercial extends Persona {
  // Atributos
  private String cargo;
  
  
  // Métodos
  public Comercial(String nombre, String correo, String cargo) {
    super(nombre, correo);
    this.cargo = cargo;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  @Override
  public String toString() {
    String resultado = "\nNombre: " + super.getNombre() +
                       "\nCorreo electronico: " + super.getCorreo() +
                       "\nCargo: " + this.cargo +
                       "\nVentas realizadas" +
                       "\n=================\n";
    
    for (Articulo articulo : super.getVenta()) {
      resultado += articulo;
    }
            
    
    return resultado;
  }
  
}
