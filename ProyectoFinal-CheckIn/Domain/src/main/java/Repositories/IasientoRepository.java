package Repositories;

import Modal.Asiento;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IasientoRepository extends IRepository<Asiento, UUID> {
  public List<Asiento> GetAll() throws Exception;

  public Asiento Delete(Asiento asientos) throws Exception;

  public Asiento Update(Asiento asientos) throws Exception;
}
