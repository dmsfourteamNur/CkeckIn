package Application.UseCases.Queries.pasajero.GetByIdVuelo;

import org.junit.Test;

import UseCases.Queries.pasajero.GetByIdVuelo.GetVueloPasajeroQuery;

public class GetVueloPasajeroQuery_Test {

  @Test
  public void HandleCorrectly() throws Exception {
    GetVueloPasajeroQuery query = new GetVueloPasajeroQuery(1);
  }
}
