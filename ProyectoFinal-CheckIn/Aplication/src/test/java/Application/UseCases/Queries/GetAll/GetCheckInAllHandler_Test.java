package Application.UseCases.Queries.GetAll;

import org.junit.Test;
import org.mockito.Mockito;

import Repositories.IcheckInRepository;
import UseCases.Queries.GetAll.GetCheckInAllHandler;
import UseCases.Queries.GetAll.GetCheckInAllQuery;

public class GetCheckInAllHandler_Test {

  IcheckInRepository icheckInRepository = Mockito.mock(IcheckInRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    GetCheckInAllHandler handler = new GetCheckInAllHandler(icheckInRepository);
    GetCheckInAllQuery query = new GetCheckInAllQuery();
    handler.handle(query);
  }
}
