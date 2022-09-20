package Dto;

import java.util.UUID;

public class PasajeroDto {

  private UUID key;
  private String keyVuelo;
  private String nombre;
  private String apellido;
  private int dni;

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public String getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(String keyVuelo) {
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

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }
}
