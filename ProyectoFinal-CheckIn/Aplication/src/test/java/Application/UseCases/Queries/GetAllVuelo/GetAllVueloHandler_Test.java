package Application.UseCases.Queries.GetAllVuelo;

import org.junit.Test;
import org.mockito.Mockito;

import Repositories.IitinerarioRepository;
import UseCases.Queries.GetAllVuelo.GetAllVueloHandler;
import UseCases.Queries.GetAllVuelo.GetAllVueloQuery;

public class GetAllVueloHandler_Test {

  IitinerarioRepository iitinerarioRepository = Mockito.mock(IitinerarioRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    GetAllVueloHandler handler = new GetAllVueloHandler(iitinerarioRepository);
    GetAllVueloQuery query = new GetAllVueloQuery();
    handler.handle(query);
  }
}
