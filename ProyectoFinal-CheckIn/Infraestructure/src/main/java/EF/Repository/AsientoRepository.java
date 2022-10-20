package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Modal.Asiento;
import Repositories.IasientoRepository;
import java.util.List;
import java.util.UUID;

public class AsientoRepository implements IasientoRepository {

  private DbSet<Asiento> _asiento;

  @Override
  public Asiento FindByKey(UUID key) throws Exception {
    return _asiento.Single(obj -> obj.key.equals(key));
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
    _asiento.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Asiento Update(Asiento obj) throws Exception {
    _asiento.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
