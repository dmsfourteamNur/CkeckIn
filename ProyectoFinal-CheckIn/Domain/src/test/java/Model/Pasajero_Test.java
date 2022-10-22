package Model;

import Modal.Pasajero;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class Pasajero_Test {

  @Test
  public void Correctly() {
    String Name = "edson";
    String LastName = "Mamani Veizga";
    UUID keyVenta = UUID.randomUUID();
    int Dni = 7576586;

    Pasajero pasajero = new Pasajero(keyVenta, keyVenta, Name, LastName, Dni);

    Pasajero passenger = new Pasajero();

    passenger.setNombre(pasajero.getNombre());
    passenger.setApellido(pasajero.getApellido());
    passenger.setKeyVenta(pasajero.getKeyVenta());
    passenger.setDni(pasajero.getDni());

    Assert.assertEquals(Dni, passenger.getDni());
    Assert.assertEquals(Name, passenger.getNombre());
    Assert.assertEquals(LastName, passenger.getApellido());
    Assert.assertEquals(keyVenta, passenger.getKeyVenta());
  }
}
