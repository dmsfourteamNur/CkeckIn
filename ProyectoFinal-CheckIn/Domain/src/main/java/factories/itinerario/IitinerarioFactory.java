package factories.itinerario;

import Modal.Itinerario;
import java.util.Date;
import java.util.UUID;

public interface IitinerarioFactory {
  Itinerario Create(UUID key, String origen, String destino, Date fechaSalida, Date fechaArribe);
}
