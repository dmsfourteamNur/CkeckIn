package Repositories;

import Modal.Itinerario;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IitinerarioRepository extends IRepository<Itinerario, UUID> {
  public List<Itinerario> GetAll() throws Exception;

  public Itinerario Delete(Itinerario itinerario) throws Exception;

  public Itinerario Update(Itinerario itinerario) throws Exception;
}
