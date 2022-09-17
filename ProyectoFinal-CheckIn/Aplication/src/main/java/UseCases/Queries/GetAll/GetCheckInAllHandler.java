package UseCases.Queries.GetAll;

import Modal.CheckIn;
import Repositories.IcheckInRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
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
