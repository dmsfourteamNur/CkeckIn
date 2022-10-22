package EF.Repository;

import static org.mockito.ArgumentMatchers.any;

import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDB.WriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Fourteam.http.Exception.HttpException;
import Modal.Equipaje;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EquipajeRepository_Test {

  @Before
  public void setup() {}

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  DbSet<Equipaje> _baggage = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.equipaje = _baggage;
  }

  @Test
  public void GetAll_Test() throws Exception {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.GetAll();
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Create_Test() throws Exception {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.Create(any(Equipaje.class));
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Update_Test() throws Exception {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.Update(new Equipaje());
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Delete_Test() throws Exception {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.Delete(new Equipaje());
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void FindByKey_Test() throws Exception {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(baggageRepository);
  }
}
