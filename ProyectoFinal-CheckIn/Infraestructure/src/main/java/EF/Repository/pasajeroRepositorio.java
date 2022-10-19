package EF.Repository;

import java.util.List;
import java.util.UUID;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Modal.Pasajero;
import Repositories.IpasajeroRepository;

public class pasajeroRepositorio implements IpasajeroRepository {

  private DbSet<Pasajero> pasajero;

  public pasajeroRepositorio(IWriteDbContext database) {
    pasajero = database.pasajero;
  }

  @Override
  public Pasajero FindByKey(UUID key) throws Exception {
    return pasajero.Single(obj -> obj.key.toString().equals(key.toString()));
  }

  @Override
  public void Create(Pasajero obj) throws Exception {
    pasajero.Add(obj);
  }

  @Override
  public List<Pasajero> GetAll() throws Exception {
    return pasajero.All();
  }

  @Override
  public Pasajero Delete(Pasajero obj) throws Exception {
    pasajero.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Pasajero Update(Pasajero obj) throws Exception {
    pasajero.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Pasajero FindByKeyVenta(UUID keyVenta) throws Exception {
    return pasajero.Single(obj -> obj.getKeyVenta().toString().equals(keyVenta.toString()));
  }

  @Override
  public Pasajero FindByKeyPasajero(int ci) throws Exception {
    return pasajero.Single(obj -> obj.getDni() == ci);
  }

  @Override
  public Pasajero FindByKeyVuelo(UUID keyVuelo) throws Exception {
    return pasajero.Single(obj -> obj.getKey().toString().equals(keyVuelo.toString()));
  }

}
