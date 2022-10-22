package Modal;

import core.AggregateRoot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Itinerario extends AggregateRoot<UUID> {

  private String origen;
  private String destino;
  private Date fechaSalida;
  private Date fechaArribe;
  private List<Asiento> asiento;

  public Itinerario() {}

  public Itinerario(
    UUID keyVuelo,
    String origen,
    String destino,
    Date fechaSalida,
    Date fechaArribe
  ) {
    this.key = keyVuelo;
    this.origen = origen;
    this.destino = destino;
    this.fechaArribe = fechaArribe;
    this.fechaSalida = fechaSalida;
    this.asiento = new ArrayList<Asiento>();
  }

  public void AgregarAsientos(UUID key, int numeroAsiento, int disponibilidad) {
    Asiento asientos = new Asiento(key, numeroAsiento, disponibilidad);
    asiento.add(asientos);
  }

  public String getOrigen() {
    return this.origen;
  }

  public void setOrigen(String origen) {
    this.origen = origen;
  }

  public String getDestino() {
    return this.destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
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
