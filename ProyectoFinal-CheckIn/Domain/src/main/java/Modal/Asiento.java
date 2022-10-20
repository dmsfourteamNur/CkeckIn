package Modal;

import core.Entity;
import java.util.UUID;

public class Asiento extends Entity<UUID> {

  private int numeroAsiento;
  private int disponibilidad;

  public Asiento() {}

  public Asiento(UUID key, int numeroAsiento, int disponibilidad) {
    this.key = key;
    this.numeroAsiento = numeroAsiento;
    this.disponibilidad = disponibilidad;
  }

  public void setNumero(int numero) {
    this.numeroAsiento = numero;
  }

  public int getNumero() {
    return numeroAsiento;
  }

  public void setDisponibilidad(int disponibilidad) {
    this.disponibilidad = disponibilidad;
  }

  public int getDisponibilidad() {
    return disponibilidad;
  }
}
