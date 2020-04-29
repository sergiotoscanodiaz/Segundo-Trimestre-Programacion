
package Ex18std4;

public class Empresa implements Cliente {
  // Atributos
  private String CIF;
  private String nombre;
  private String telefono;
  
  // Métodos
  public Empresa(String CIF, String nombre, String telefono) {
    this.CIF = CIF;
    this.nombre = nombre;
    this.telefono = telefono;
  }
  
  @Override
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
  
  
  
}
