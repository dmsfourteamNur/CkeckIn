package Repositories;

import java.util.List;
import java.util.UUID;

import Modal.Asiento;
import core.IRepository;

public interface IasientoRepository extends IRepository<Asiento, UUID> {

  public List<Asiento> GetAll() throws Exception;

  public Asiento Delete(Asiento asientos) throws Exception;

  public Asiento Update(Asiento asientos) throws Exception;
}
