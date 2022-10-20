package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Modal.Equipaje;
import Repositories.IequipajeRepository;
import java.util.List;
import java.util.UUID;

public class EquipajeRepository implements IequipajeRepository {

  private DbSet<Equipaje> _equipaje;

  public EquipajeRepository(IWriteDbContext database) {
    _equipaje = database.equipaje;
  }

  @Override
  public Equipaje FindByKey(UUID key) throws Exception {
    return _equipaje.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Equipaje obj) throws Exception {
    _equipaje.Add(obj);
  }

  @Override
  public List<Equipaje> GetAll() throws Exception {
    return _equipaje.All();
  }

  @Override
  public Equipaje Delete(Equipaje obj) throws Exception {
    _equipaje.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Equipaje Update(Equipaje obj) throws Exception {
    _equipaje.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
