package Modal;

import core.AggregateRoot;
import java.util.UUID;

public class Pasajero extends AggregateRoot<UUID> {

  private UUID keyVenta;
  private String nombre;
  private String apellido;
  private int dni;

  public Pasajero() {
  }

  public Pasajero(UUID keyVuelo, UUID keyVenta, String nombre, String apellido, int dni) {
    this.key = keyVuelo;
    this.keyVenta = keyVenta;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public UUID getKeyVenta() {
    return this.keyVenta;
  }

  public void setKeyVenta(UUID keyVenta) {
    this.keyVenta = keyVenta;
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

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

}
