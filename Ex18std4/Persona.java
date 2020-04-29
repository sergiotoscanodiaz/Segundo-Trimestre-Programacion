
package Ex18std4;

import java.util.ArrayList;


public abstract class Persona {
  // Atributos
  private String nombre;
  private String correo;
  private ArrayList<Articulo> venta = new ArrayList<>();
  
  // Métodos
  public Persona(String nombre, String correo) {
    this.nombre = nombre;
    this.correo = correo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public ArrayList<Articulo> getVenta() {
    return venta;
  }
  
  public void compra(Persona p1, Articulo a1) {
    if (p1.getVenta().contains(a1)) {
      int cantidadNueva = a1.getCantidad();
      int posicion = p1.getVenta().indexOf(a1);
      int cantidadAntigua = p1.getVenta().get(posicion).getCantidad();
      int cantidadActualizada = cantidadAntigua + cantidadNueva;
      p1.getVenta().get(posicion).setCantidad(cantidadActualizada);
    } else {
      p1.getVenta().add(a1);
    }
  }

  @Override
  public String toString() {
    String resultado = "\nNombre: " + this.nombre +
                       "\nCorreo electronico: " + this.correo +
                       "\nVentas realizadas" +
                       "\n=================\n";
    
    for (Articulo articulo : venta) {
      resultado += articulo;
    }
            
    
    return resultado;
  }
  
}
