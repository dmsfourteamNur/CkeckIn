package factories.itinerario;

import Modal.Itinerario;

import java.util.Date;
import java.util.UUID;

public class ItinerarioFactory implements IitinerarioFactory {

  @Override
  public Itinerario Create(UUID key, UUID ciudadOrigen, UUID ciudadDestino, Date fechaSalida,
      Date fechaArribe) {
    return new Itinerario(key, ciudadOrigen, ciudadDestino, fechaSalida, fechaArribe);
  }
}
