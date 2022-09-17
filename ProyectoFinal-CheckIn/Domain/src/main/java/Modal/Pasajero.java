package Modal;

import core.AggregateRoot;
import java.util.UUID;

public class Pasajero extends AggregateRoot<UUID> {

  private UUID keyVuelo;
  private String nombre;
  private String apellido;
  private int dni;

  public Pasajero() {}

  public Pasajero(UUID key, UUID _keyVuelo, String nombre, String apellido, int dni) {
    this.key = key;
    this.keyVuelo = _keyVuelo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public UUID getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
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
