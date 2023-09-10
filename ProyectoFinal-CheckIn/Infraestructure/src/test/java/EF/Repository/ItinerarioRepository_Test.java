package EF.Repository;

import static org.mockito.ArgumentMatchers.any;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Modal.Itinerario;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ItinerarioRepository_Test {

  @Before
  public void setup() {
  }

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  Fourteam.db.DbSet<Itinerario> _CheckIn = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.itinerario = _CheckIn;
  }

  @Test
  public void probando_lambda_by_key() {
    ItinerarioRepository repository = new ItinerarioRepository(bdTest);
    Itinerario a = new Itinerario();
    a.key = UUID.randomUUID();
    BooleanFunction<Itinerario> equalkey = repository.equalKey(a.key);
    equalkey.run(a);
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
