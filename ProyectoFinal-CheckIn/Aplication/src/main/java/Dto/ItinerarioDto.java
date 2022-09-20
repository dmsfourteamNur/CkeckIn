package Dto;

import Modal.Asiento;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ItinerarioDto {

  private UUID key;
  private UUID ciudadOrigen;
  private UUID ciudadDestino;
  private Date fechaSalida;
  private Date fechaArribe;
  private List<Asiento> asientos;

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

  public Date getFechaSalida() {
    return this.fechaSalida;
  }

  public void setFechaSalida(Date fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public Date getFechaArribe() {
    return this.fechaArribe;
  }

  public void setFechaArribe(Date fechaArribe) {
    this.fechaArribe = fechaArribe;
  }

  public List<Asiento> getAsientos() {
    return this.asientos;
  }

  public void setAsientos(List<Asiento> asientos) {
    this.asientos = asientos;
  }

}
