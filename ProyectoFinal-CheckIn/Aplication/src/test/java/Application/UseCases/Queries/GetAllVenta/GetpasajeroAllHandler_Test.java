package Application.UseCases.Queries.GetAllVenta;

import org.junit.Test;
import org.mockito.Mockito;

import Repositories.IpasajeroRepository;
import UseCases.Queries.GetAllVenta.GetpasajeroAllHandler;
import UseCases.Queries.GetAllVenta.GetpasajeroAllQuery;

public class GetpasajeroAllHandler_Test {
  IpasajeroRepository icheckInRepository = Mockito.mock(IpasajeroRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    GetpasajeroAllHandler handler = new GetpasajeroAllHandler(icheckInRepository);
    GetpasajeroAllQuery query = new GetpasajeroAllQuery();
    handler.handle(query);
  }
}
