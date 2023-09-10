package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Modal.Asiento;
import Modal.CheckIn;
import Repositories.IcheckInRepository;
import java.util.List;
import java.util.UUID;

public class CheckInRepository implements IcheckInRepository {

  private DbSet<CheckIn> _checkIn;

  public CheckInRepository(IWriteDbContext database) {
    _checkIn = database.checkIn;
  }

  public BooleanFunction<CheckIn> equalKey(UUID key) {
    return obj -> obj.key.equals(key);
  }

  @Override
  public CheckIn FindByKey(UUID key) throws Exception {
    return _checkIn.Single(equalKey(key));
  }

  @Override
  public void Create(CheckIn obj) throws Exception {
    _checkIn.Add(obj);
  }

  @Override
  public List<CheckIn> GetAll() throws Exception {
    return _checkIn.All();
  }

  @Override
  public CheckIn Delete(CheckIn obj) throws Exception {
    _checkIn.Delete(equalKey(obj.key));
    return obj;
  }

  @Override
  public CheckIn Update(CheckIn obj) throws Exception {
    _checkIn.Update(obj, equalKey(obj.key));
    return obj;
  }
}
