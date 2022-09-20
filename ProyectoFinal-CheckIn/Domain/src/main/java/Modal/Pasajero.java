package Modal;

import core.AggregateRoot;
import java.util.UUID;

public class Pasajero extends AggregateRoot<UUID> {

  private String nombre;
  private String apellido;
  private int dni;

  public Pasajero() {
  }

  public Pasajero(UUID keyVuelo, String nombre, String apellido, int dni) {
    this.key = keyVuelo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getnombre() {
    return nombre;
  }

  public void setnombre(String nombre) {
    this.nombre = nombre;
  }

  public String getapellido() {
    return apellido;
  }

  public void setapellido(String apellido) {
    this.apellido = apellido;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }
}
