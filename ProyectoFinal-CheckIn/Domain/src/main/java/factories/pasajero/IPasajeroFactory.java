package factories.pasajero;

import java.util.UUID;

import Modal.Pasajero;

public interface IPasajeroFactory {
  Pasajero Create(
      UUID key,
      String nombre,
      String apellido,
      int dni);
}
