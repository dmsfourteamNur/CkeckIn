package Repositories;

import Modal.Pasajero;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IpasajeroRepository extends IRepository<Pasajero, Integer> {
  public List<Pasajero> GetAll() throws Exception;

  public Pasajero Delete(Pasajero pasajero) throws Exception;

  public Pasajero Update(Pasajero pasajero) throws Exception;
}
