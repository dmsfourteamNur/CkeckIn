package Dto;

import java.util.UUID;

public class Asiento {

  private UUID key;
  private int numeroAsiento;
  private int disponibilidad;

  public Asiento() {}

  public Asiento(UUID key, int numeroAsiento, int disponibilidad) {
    this.key = key;
    this.numeroAsiento = numeroAsiento;
    this.disponibilidad = disponibilidad;
  }

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public int getNumeroAsiento() {
    return this.numeroAsiento;
  }

  public void setNumeroAsiento(int numeroAsiento) {
    this.numeroAsiento = numeroAsiento;
  }

  public int getDisponibilidad() {
    return this.disponibilidad;
  }

  public void setDisponibilidad(int disponibilidad) {
    this.disponibilidad = disponibilidad;
  }
}
