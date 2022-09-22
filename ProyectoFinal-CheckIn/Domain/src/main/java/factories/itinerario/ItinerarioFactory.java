package factories.itinerario;

import Modal.Itinerario;
import java.util.Date;
import java.util.UUID;

public class ItinerarioFactory implements IitinerarioFactory {

  @Override
  public Itinerario Create(UUID key, String origen, String destino, Date fechaSalida,
      Date fechaArribe) {
    return new Itinerario(key, origen, destino, fechaSalida, fechaArribe);
  }
}
