package Factories.pasajero;

import factories.pasajero.PasajeroFactory;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class PasajeroFactory_test {

  @Test
  public void constructor_accept() {
    Assert.assertNotNull(new PasajeroFactory());
  }

  @Test
  public void create_accept() {
    Assert.assertNotNull(
      new PasajeroFactory().Create(UUID.randomUUID(), UUID.randomUUID(), "sdfsd", "sds", 323244)
    );
  }
}
