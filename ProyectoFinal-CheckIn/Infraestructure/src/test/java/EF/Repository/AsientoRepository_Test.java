package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Modal.Asiento;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

import java.util.UUID;
import org.junit.Assert;

public class AsientoRepository_Test {

  @Before
  public void setup() {
  }

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  Fourteam.db.DbSet<Asiento> _asiento = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.asiento = _asiento;
  }

  @Test
  public void probando_lambda_by_key() {
    AsientoRepository repository = new AsientoRepository(bdTest);
    Asiento a = new Asiento();
    a.key = UUID.randomUUID();
    BooleanFunction<Asiento> equalkey = repository.equalKey(a.key);
    equalkey.run(a);
  }

  @Test
  public void GetAll_Test() throws Exception {
    AsientoRepository asientoRepository = new AsientoRepository(bdTest);
    asientoRepository.GetAll();
    Assert.assertNotNull(asientoRepository);
  }

  @Test
  public void Create_Test() throws Exception {
    AsientoRepository asientoRepository = new AsientoRepository(bdTest);
    asientoRepository.Create(any(Asiento.class));
    Assert.assertNotNull(asientoRepository);
  }

  @Test
  public void Update_Test() throws Exception {
    AsientoRepository asientoRepository = new AsientoRepository(bdTest);
    asientoRepository.Update(new Asiento());
    Assert.assertNotNull(asientoRepository);
  }

  @Test
  public void Delete_Test() throws Exception {
    AsientoRepository asientoRepository = new AsientoRepository(bdTest);
    asientoRepository.Delete(new Asiento());
    Assert.assertNotNull(asientoRepository);
  }

  @Test
  public void FindByKey_Test() throws Exception {
    AsientoRepository asientoRepository = new AsientoRepository(bdTest);
    asientoRepository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(asientoRepository);
  }

}
