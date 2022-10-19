package UseCases.Queries.GetAllVenta;

import java.util.List;

import Fourteam.mediator.RequestHandler;
import Modal.Pasajero;
import Repositories.IpasajeroRepository;

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
