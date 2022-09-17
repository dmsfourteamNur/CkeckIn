package Repositories;

import Modal.Pasajero;
import core.IRepository;
import java.util.List;

public interface IpasajeroRepository extends IRepository<Pasajero, Integer> {
  public List<Pasajero> GetAll();

  public Pasajero Delete(Pasajero pasajero);

  public Pasajero Update(Pasajero pasajero);
}
