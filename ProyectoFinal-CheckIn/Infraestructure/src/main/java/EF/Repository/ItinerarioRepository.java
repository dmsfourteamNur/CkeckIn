package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Fourteam.db.DbSet;
import Modal.Itinerario;
import Repositories.IitinerarioRepository;
import java.util.List;
import java.util.UUID;

public class ItinerarioRepository implements IitinerarioRepository {

  private DbSet<Itinerario> itinerario;

  public ItinerarioRepository(IWriteDbContext database) {
    itinerario = database.itinerario;
  }

  @Override
  public Itinerario FindByKey(UUID key) throws Exception {
    return itinerario.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Itinerario obj) throws Exception {
    itinerario.Add(obj);
  }

  @Override
  public List<Itinerario> GetAll() throws Exception {
    return itinerario.All();
  }

  @Override
  public Itinerario Delete(Itinerario obj) throws Exception {
    itinerario.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Itinerario Update(Itinerario obj) throws Exception {
    itinerario.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
