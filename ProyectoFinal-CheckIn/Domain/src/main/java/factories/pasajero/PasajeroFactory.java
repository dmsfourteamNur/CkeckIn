package factories.pasajero;

import Modal.Pasajero;

import java.util.UUID;

public class PasajeroFactory implements IPasajeroFactory {

  @Override
  public Pasajero Create(UUID keyVuelo, UUID keyVenta, String nombre, String apellido, int dni) {
    return new Pasajero(keyVuelo, keyVenta, nombre, apellido, dni);
  }
}
