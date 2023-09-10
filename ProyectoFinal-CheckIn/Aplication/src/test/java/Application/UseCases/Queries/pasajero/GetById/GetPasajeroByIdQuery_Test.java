package Application.UseCases.Queries.pasajero.GetById;

import static org.junit.Assert.*;
import UseCases.Queries.pasajero.GetById.GetPasajeroByIdQuery;
import org.junit.Test;

public class GetPasajeroByIdQuery_Test {

  @Test
  public void constructor_SetsDniCorrectly() {
    int dni = 12345678;
    GetPasajeroByIdQuery query = new GetPasajeroByIdQuery(dni);
    assertEquals(dni, query.dni);
  }

  @Test
  public void constructor_SetsDniToZeroWhenNegativeValueGiven() {
    int negativeDni = 0;
    GetPasajeroByIdQuery query = new GetPasajeroByIdQuery(negativeDni);
    assertEquals(0, query.dni);
  }
}
