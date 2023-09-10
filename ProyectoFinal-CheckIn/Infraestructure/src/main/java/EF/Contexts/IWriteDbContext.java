package EF.Contexts;

import Modal.Asiento;
import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Modal.CheckIn;
import Modal.Equipaje;
import Modal.Itinerario;
import Modal.Pasajero;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<CheckIn> checkIn;
  public DbSet<Equipaje> equipaje;
  public DbSet<Itinerario> itinerario;
  public DbSet<Pasajero> pasajero;
  public DbSet<Asiento> asiento;
}
