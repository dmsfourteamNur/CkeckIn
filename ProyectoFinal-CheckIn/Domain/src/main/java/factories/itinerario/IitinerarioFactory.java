package factories.itinerario;

import Modal.Itinerario;

import java.util.Date;
import java.util.UUID;

public interface IitinerarioFactory {
  Itinerario Create(
      String key,
      String ciudadOrigen,
      String ciudadDestino,
      Date fechaSalida,
      Date fechaArribe);
}
