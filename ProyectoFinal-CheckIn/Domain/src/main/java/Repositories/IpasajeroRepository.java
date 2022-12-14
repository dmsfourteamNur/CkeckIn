package Repositories;

import Modal.Pasajero;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IpasajeroRepository extends IRepository<Pasajero, UUID> {
  public List<Pasajero> GetAll() throws Exception;

  public Pasajero Delete(Pasajero pasajero) throws Exception;

  public Pasajero Update(Pasajero pasajero) throws Exception;

  public Pasajero FindByKeyVenta(UUID keyVenta) throws Exception;

  public Pasajero FindByKeyPasajero(int ci) throws Exception;

  public Pasajero FindByKeyVuelo(UUID keyVuelo) throws Exception;
}
