package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Modal.Asiento;
import Repositories.IasientoRepository;
import java.util.List;
import java.util.UUID;

public class AsientoRepository implements IasientoRepository {

  private DbSet<Asiento> _asiento;

  public BooleanFunction<Asiento> equalKey(UUID key) {
    return obj -> obj.key.equals(key);
  }

  public AsientoRepository(IWriteDbContext database) {
    _asiento = database.asiento;
  }

  @Override
  public Asiento FindByKey(UUID key) throws Exception {
    return _asiento.Single(equalKey(key));
  }

  @Override
  public void Create(Asiento obj) throws Exception {
    _asiento.Add(obj);
  }

  @Override
  public List<Asiento> GetAll() throws Exception {
    return _asiento.All();
  }

  @Override
  public Asiento Delete(Asiento obj) throws Exception {
    _asiento.Delete(equalKey(obj.key));
    return obj;
  }

  @Override
  public Asiento Update(Asiento obj) throws Exception {
    _asiento.Update(obj, equalKey(obj.key));
    return obj;
  }
}
