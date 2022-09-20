package Dto;

import java.util.List;
import java.util.UUID;

public class VueloPersonaDto {

  private UUID key;
  private UUID ciudadOrigen;
  private UUID ciudadDestino;
  private List<Asiento> asientos;

  private UUID keyPasajero;
  private UUID keyVuelo;
  private String nombre;
  private String apellido;
  private int dni;

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public UUID getCiudadOrigen() {
    return this.ciudadOrigen;
  }

  public void setCiudadOrigen(UUID ciudadOrigen) {
    this.ciudadOrigen = ciudadOrigen;
  }

  public UUID getCiudadDestino() {
    return this.ciudadDestino;
  }

  public void setCiudadDestino(UUID ciudadDestino) {
    this.ciudadDestino = ciudadDestino;
  }

  public List<Asiento> getAsientos() {
    return this.asientos;
  }

  public void setAsientos(List<Asiento> asientos) {
    this.asientos = asientos;
  }

  public UUID getKeyPasajero() {
    return this.keyPasajero;
  }

  public void setKeyPasajero(UUID keyPasajero) {
    this.keyPasajero = keyPasajero;
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

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

}
