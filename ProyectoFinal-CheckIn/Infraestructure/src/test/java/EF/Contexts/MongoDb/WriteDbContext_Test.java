package EF.Contexts.MongoDb;

import EF.Contexts.MongoDB.WriteDbContext;
import Fourteam.config.Config;
import Modal.CheckIn;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class WriteDbContext_Test {

  @Before
  public void setUp() {
    Config.load(getClass().getClassLoader().getResource("config.properties").getFile());
  }

  @Test
  public void constructor_accept() throws Exception {
    WriteDbContext context = new WriteDbContext();
    Assert.assertNotNull(context);
  }

  @Test
  public void FindByKey_accept() throws Exception {
    // Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
    // Aeronave a = new Aeronave();
    // when(_aeronaves.Single(any())).thenReturn(a);
    WriteDbContext context = new WriteDbContext();
    ArgumentCaptor<CheckIn> captor = ArgumentCaptor.forClass(CheckIn.class);
    Assert.assertNotNull(context);
  }
}
