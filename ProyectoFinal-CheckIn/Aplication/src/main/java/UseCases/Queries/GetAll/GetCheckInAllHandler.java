package UseCases.Queries.GetAll;

import Modal.CheckIn;
import Repositories.IcheckInRepository;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;
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
