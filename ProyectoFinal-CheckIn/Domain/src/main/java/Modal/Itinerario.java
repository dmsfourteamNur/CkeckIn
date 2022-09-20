package Modal;

import core.AggregateRoot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Itinerario extends AggregateRoot<UUID> {

  private UUID ciudadOrigen;
  private UUID ciudadDestino;
  private Date fechaSalida;
  private Date fechaArribe;
  private List<Asiento> asiento;

  public Itinerario(
      UUID keyVuelo,
      UUID ciudadOrigen,
      UUID ciudadDestino,
      Date fechaSalida,
      Date fechaArribe) {
    this.key = keyVuelo;
    this.ciudadOrigen = ciudadOrigen;
    this.ciudadDestino = ciudadDestino;
    this.fechaArribe = fechaArribe;
    this.fechaSalida = fechaSalida;
    this.asiento = new ArrayList<Asiento>();
  }

  public void AgregarAsientos(UUID key, int numeroAsiento, int disponibilidad) {
    Asiento asientos = new Asiento(key, numeroAsiento, disponibilidad);
    asiento.add(asientos);
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

  public List<Asiento> getAsiento() {
    return this.asiento;
  }

  public void setAsiento(List<Asiento> asiento) {
    this.asiento = asiento;
  }

}
