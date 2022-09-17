package factories.itinerario;

import Modal.Itinerario;

import java.util.Date;
import java.util.UUID;

public class ItinerarioFactory implements IitinerarioFactory {

  @Override
  public Itinerario Create(String key, String ciudadOrigen, String ciudadDestino, Date fechaSalida,
      Date fechaArribe) {
    return new Itinerario(key, ciudadOrigen, ciudadDestino, fechaSalida, fechaArribe);
  }

  // @Override
  // public Itinerario Create(UUID key, String ciudadOrigen, String ciudadDestino,
  // Date fechaSalida,
  // Date fechaArribe) {
  // return new Itinerario(key, ciudadOrigen, ciudadDestino, fechaSalida,
  // fechaArribe);
  // }
}
