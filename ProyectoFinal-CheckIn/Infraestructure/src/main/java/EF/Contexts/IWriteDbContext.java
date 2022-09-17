package EF.Contexts;

import Modal.CheckIn;
import Modal.Equipaje;
import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<CheckIn> checkIn;
  public DbSet<Equipaje> equipaje;
}
