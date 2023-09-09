package Application.UseCases.Queries.GetById;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.CheckInDto;
import Modal.CheckIn;
import Repositories.IcheckInRepository;
import UseCases.Queries.GetById.GetCheckInByIdHandler;
import UseCases.Queries.GetById.GetCheckInByIdQuery;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetCheckInByIdHandler_Test {

  IcheckInRepository icheckInRepository = Mockito.mock(IcheckInRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    String CodigoSeguridad = "dsfds";
    int Asiento = 33;
    Boolean EstadoPaciente = true;
    String Descripcion = "haskjhfaksjf";
    UUID keyVuelo = UUID.randomUUID();
    UUID keyAsiento = UUID.randomUUID();
    UUID keyVenta = UUID.randomUUID();

    CheckIn objCheckIn = new CheckIn(
        CodigoSeguridad,
        EstadoPaciente,
        Descripcion,
        Asiento,
        keyVuelo,
        keyAsiento,
        keyVenta);
    objCheckIn.AgregarItem(3.2, "Sdfds", "asdasfasa");

    when(icheckInRepository.FindByKey(any())).thenReturn(objCheckIn);

    GetCheckInByIdHandler handler = new GetCheckInByIdHandler(icheckInRepository);
    GetCheckInByIdQuery query = new GetCheckInByIdQuery(objCheckIn.getKey());
    CheckInDto resp = handler.handle(query);

    try {
      Assert.assertNotNull(resp);
    } catch (Exception e) {
      Assert.fail();
    }

    verify(icheckInRepository).FindByKey(objCheckIn.key);
  }
}
