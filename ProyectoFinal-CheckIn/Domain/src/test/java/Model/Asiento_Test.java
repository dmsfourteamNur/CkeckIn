package Model;

import Modal.Asiento;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class Asiento_Test {

  @Test
  public void Correctly() {
    int numeroAsiento = 34;
    int disponibilidad = 0;
    Asiento asiento = new Asiento(UUID.randomUUID(), numeroAsiento, disponibilidad);
    Asiento asientos = new Asiento();

    asientos.setDisponibilidad(disponibilidad);
    asientos.setNumero(numeroAsiento);

    Assert.assertEquals(numeroAsiento, asiento.getNumero());
    Assert.assertEquals(disponibilidad, asiento.getDisponibilidad());
  }
}
