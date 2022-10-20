package factories.pasajero;

import Modal.Pasajero;
import java.util.UUID;

public interface IPasajeroFactory {
  Pasajero Create(UUID key, UUID keyVenta, String nombre, String apellido, int dni);
}
