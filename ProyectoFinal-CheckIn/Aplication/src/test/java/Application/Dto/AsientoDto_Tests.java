package Application.Dto;

import Dto.Asiento;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AsientoDto_Tests {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    int numeroAsiento = 23;
    int disponibilidad = 0;

    Asiento asiento = new Asiento();

    asiento.setKey(key);
    asiento.setNumeroAsiento(numeroAsiento);
    asiento.setDisponibilidad(disponibilidad);

    Assert.assertEquals(key, asiento.getKey());
    Assert.assertEquals(numeroAsiento, asiento.getNumeroAsiento());
    Assert.assertEquals(disponibilidad, asiento.getDisponibilidad());
  }
}
