package UseCases.Queries.GetAll;

import Fourteam.mediator.RequestHandler;
import Modal.CheckIn;
import Repositories.IcheckInRepository;
import java.util.List;

public class GetCheckInAllHandler implements RequestHandler<GetCheckInAllQuery, List<CheckIn>> {

  private IcheckInRepository _checkInRepository;

  public GetCheckInAllHandler(IcheckInRepository icheckInRepository) {
    this._checkInRepository = icheckInRepository;
  }

  @Override
  public List<CheckIn> handle(GetCheckInAllQuery request) throws Exception {
    return _checkInRepository.GetAll();
  }
}
