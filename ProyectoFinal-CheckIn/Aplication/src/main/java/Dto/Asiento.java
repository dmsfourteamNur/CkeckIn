package Dto;

import java.util.UUID;

public class Asiento {

  private UUID key;
  private String numeroAsiento;
  private int disponibilidad;

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public String getNumeroAsiento() {
    return this.numeroAsiento;
  }

  public void setNumeroAsiento(String numeroAsiento) {
    this.numeroAsiento = numeroAsiento;
  }

  public int getDisponibilidad() {
    return this.disponibilidad;
  }

  public void setDisponibilidad(int disponibilidad) {
    this.disponibilidad = disponibilidad;
  }
}
