package EF.Repository;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Modal.Pasajero;

public class PasajeroRapositoryTest {

  @Before
  public void setup() {
  }

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  DbSet<Pasajero> _Pasajero = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.pasajero = _Pasajero;
  }

  @Test
  public void GetAll_Test() throws Exception {
    pasajeroRepositorio pasajeroRepository = new pasajeroRepositorio(bdTest);
    pasajeroRepository.GetAll();
    Assert.assertNotNull(pasajeroRepository);
  }

  @Test
  public void Update_Test() throws Exception {
    pasajeroRepositorio pasajeroRepository = new pasajeroRepositorio(bdTest);
    pasajeroRepository.Update(new Pasajero());
    Assert.assertNotNull(pasajeroRepository);
  }

  @Test
  public void Delete_Test() throws Exception {
    pasajeroRepositorio pasajeroRepository = new pasajeroRepositorio(bdTest);
    pasajeroRepository.Delete(new Pasajero());
    Assert.assertNotNull(pasajeroRepository);
  }

  @Test
  public void Create_Test() throws Exception {
    pasajeroRepositorio pasajeroRepository = new pasajeroRepositorio(bdTest);
    pasajeroRepository.Create(new Pasajero());
    Assert.assertNotNull(pasajeroRepository);
  }

  @Test
  public void probando_lambda_by_key() {
    pasajeroRepositorio repository = new pasajeroRepositorio(bdTest);
    Pasajero a = new Pasajero();
    a.key = UUID.randomUUID();
    BooleanFunction<Pasajero> equalkey = repository.equalKey(a.key);
    equalkey.run(a);
  }
}
