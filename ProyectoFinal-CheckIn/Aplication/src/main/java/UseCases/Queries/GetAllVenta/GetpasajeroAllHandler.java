package UseCases.Queries.GetAllVenta;

import Fourteam.mediator.RequestHandler;
import Modal.Pasajero;
import Repositories.IpasajeroRepository;
import java.util.List;

public class GetpasajeroAllHandler implements RequestHandler<GetpasajeroAllQuery, List<Pasajero>> {

  private IpasajeroRepository _IpasajeroRepository;

  public GetpasajeroAllHandler(IpasajeroRepository _IpasajeroRepository) {
    this._IpasajeroRepository = _IpasajeroRepository;
  }

  @Override
  public List<Pasajero> handle(GetpasajeroAllQuery request) throws Exception {
    return _IpasajeroRepository.GetAll();
  }
}
