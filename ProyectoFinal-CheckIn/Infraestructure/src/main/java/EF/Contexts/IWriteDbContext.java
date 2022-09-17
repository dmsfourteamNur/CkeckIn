package EF.Contexts;

import Modal.CheckIn;
import Modal.Equipaje;
import fourteam.db.DbContext;
import fourteam.db.DbSet;
import fourteam.db.Exception.DataBaseException;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<CheckIn> checkIn;
  public DbSet<Equipaje> equipaje;
}
