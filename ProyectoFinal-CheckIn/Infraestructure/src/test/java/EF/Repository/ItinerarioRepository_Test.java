package EF.Repository;

import static org.mockito.ArgumentMatchers.any;

import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDB.WriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Fourteam.http.Exception.HttpException;
import Modal.CheckIn;
import Modal.Itinerario;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ItinerarioRepository_Test {

  @Before
  public void setup() {}

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  Fourteam.db.DbSet<Itinerario> _CheckIn = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.itinerario = _CheckIn;
  }

  @Test
  public void GetAll_Test() throws Exception {
    ItinerarioRepository checkInRepository = new ItinerarioRepository(bdTest);
    checkInRepository.GetAll();
    Assert.assertNotNull(checkInRepository);
  }

  @Test
  public void Create_Test() throws Exception {
    ItinerarioRepository checkInRepository = new ItinerarioRepository(bdTest);
    checkInRepository.Create(any(Itinerario.class));
    Assert.assertNotNull(checkInRepository);
  }

  @Test
  public void Update_Test() throws Exception {
    ItinerarioRepository checkInRepository = new ItinerarioRepository(bdTest);
    checkInRepository.Update(new Itinerario());
    Assert.assertNotNull(checkInRepository);
  }

  @Test
  public void Delete_Test() throws Exception {
    ItinerarioRepository checkInRepository = new ItinerarioRepository(bdTest);
    checkInRepository.Delete(new Itinerario());
    Assert.assertNotNull(checkInRepository);
  }

  @Test
  public void FindByKey_Test() throws Exception {
    ItinerarioRepository checkInRepository = new ItinerarioRepository(bdTest);
    checkInRepository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(checkInRepository);
  }
}
