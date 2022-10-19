package UseCases.Queries.GetAllVuelo;

import java.util.List;

import Fourteam.mediator.RequestHandler;
import Modal.Itinerario;
import Repositories.IitinerarioRepository;

public class GetAllVueloHandler implements RequestHandler<GetAllVueloQuery, List<Itinerario>> {

  private IitinerarioRepository iitinerarioRepository;

  public GetAllVueloHandler(IitinerarioRepository _IItinerarioRepository) {
    this.iitinerarioRepository = _IItinerarioRepository;
  }

  @Override
  public List<Itinerario> handle(GetAllVueloQuery request) throws Exception {
    return iitinerarioRepository.GetAll();
  }

}
