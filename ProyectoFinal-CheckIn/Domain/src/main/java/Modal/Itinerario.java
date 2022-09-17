package Modal;

import core.AggregateRoot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Itinerario extends AggregateRoot<UUID> {

  private String keyVuelo;
  private String ciudadOrigen;
  private String ciudadDestino;
  private Date fechaSalida;
  private Date fechaArribe;
  private List<Asiento> asiento;

  public Itinerario() {
  }

  public Itinerario(
      String keyVuelo,
      String ciudadOrigen,
      String ciudadDestino,
      Date fechaSalida,
      Date fechaArribe) {
    this.key = UUID.randomUUID();
    this.keyVuelo = keyVuelo;
    this.ciudadOrigen = ciudadOrigen;
    this.ciudadDestino = ciudadDestino;
    this.fechaArribe = fechaArribe;
    this.fechaSalida = fechaSalida;
    this.asiento = new ArrayList<Asiento>();
  }

  public void AgregarAsientos(UUID key, String numeroAsiento, int disponibilidad) {
    Asiento asientos = new Asiento(key, numeroAsiento, disponibilidad);
    asiento.add(asientos);
  }

  public String getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(String keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public String getCiudadOrigen() {
    return this.ciudadOrigen;
  }

  public void setCiudadOrigen(String ciudadOrigen) {
    this.ciudadOrigen = ciudadOrigen;
  }

  public String getCiudadDestino() {
    return this.ciudadDestino;
  }

  public void setCiudadDestino(String ciudadDestino) {
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
