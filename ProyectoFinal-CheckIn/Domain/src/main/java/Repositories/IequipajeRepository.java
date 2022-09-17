package Repositories;

import Modal.Equipaje;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IequipajeRepository extends IRepository<Equipaje, UUID> {
  public List<Equipaje> GetAll() throws Exception;

  public Equipaje Delete(Equipaje equipaje) throws Exception;

  public Equipaje Update(Equipaje equipaje) throws Exception;
}
