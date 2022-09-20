package EF.Repository;

import java.util.List;
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
  public Pasajero FindByKey(Integer key) throws Exception {
    return pasajero.Single(obj -> obj.key.equals(key));
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

}
