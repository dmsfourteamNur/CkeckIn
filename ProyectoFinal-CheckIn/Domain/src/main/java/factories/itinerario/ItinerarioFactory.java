package factories.itinerario;

import Modal.Itinerario;
import java.sql.Date;
import java.util.UUID;

public class ItinerarioFactory implements IitinerarioFactory {

  @Override
  public Itinerario Create(
    UUID keyVuelo,
    String ciudadOrigen,
    String ciudadDestino,
    Date fechaSalida,
    Date fechaArribe
  ) {
    return new Itinerario(keyVuelo, ciudadOrigen, ciudadDestino, fechaSalida, fechaArribe);
  }
}
