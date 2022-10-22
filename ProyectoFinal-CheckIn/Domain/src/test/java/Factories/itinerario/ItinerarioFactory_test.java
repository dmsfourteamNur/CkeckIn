package Factories.itinerario;

import factories.itinerario.ItinerarioFactory;
import java.util.Date;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class ItinerarioFactory_test {

  @Test
  public void constructor_accept() {
    Assert.assertNotNull(new ItinerarioFactory());
  }

  @Test
  public void create_accept() {
    Assert.assertNotNull(
      new ItinerarioFactory().Create(UUID.randomUUID(), "Scz", "Lpz", new Date(), new Date())
    );
  }
}
