package factories.itinerario;

import Modal.Itinerario;
import java.sql.Date;
import java.util.UUID;

public interface IitinerarioFactory {
  Itinerario Create(
    UUID keyVuelo,
    String ciudadOrigen,
    String ciudadDestino,
    Date fechaSalida,
    Date fechaArribe
  );
}
