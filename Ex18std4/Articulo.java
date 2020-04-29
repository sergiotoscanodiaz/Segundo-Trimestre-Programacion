
package Ex18std4;

import java.util.Objects;

public class Articulo {
  // Atributos
  private String nombre;
  private int cantidad;
  
  // Métodos
  public Articulo(String nombre, int cantidad) {
    this.nombre = nombre;
    this.cantidad = cantidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  @Override
  public String toString() {
    String resultado = this.nombre + ", " + this.cantidad + " unid.\n";
    
    return resultado;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 43 * hash + Objects.hashCode(this.nombre);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Articulo other = (Articulo) obj;
    if (!Objects.equals(this.nombre, other.nombre)) {
      return false;
    }
    return true;
  }
  
}
