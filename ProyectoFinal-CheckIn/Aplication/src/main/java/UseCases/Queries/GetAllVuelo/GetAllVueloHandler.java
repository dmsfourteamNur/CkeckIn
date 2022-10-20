package UseCases.Queries.GetAllVuelo;

import Fourteam.mediator.RequestHandler;
import Modal.Itinerario;
import Repositories.IitinerarioRepository;
import java.util.List;

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
