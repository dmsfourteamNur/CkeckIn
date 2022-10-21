package Application.UseCases.Command.CheckIn.Edit;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import Dto.CheckInDto;
import Fourteam.http.Exception.HttpException;
import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import UseCases.Command.CheckIn.Edit.EditCheckInCommand;
import UseCases.Command.CheckIn.Edit.EditCheckInHandler;
import factories.ICheckInFactory;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EditCheckInHandler_Test {

  ICheckInFactory _checkInFactory = Mockito.mock(ICheckInFactory.class);
  IcheckInRepository _checkInRepository = Mockito.mock(IcheckInRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  int Asiento = 33;
  Boolean EstadoPaciente = true;
  String Descripcion = "haskjhfaksjf";
  String CodigoSeguridad = "dsfds";
  UUID keyVuelo = UUID.randomUUID();
  UUID keyAsiento = UUID.randomUUID();
  UUID keyVenta = UUID.randomUUID();

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    CheckIn objCheckIn = new CheckIn(
      CodigoSeguridad,
      EstadoPaciente,
      Descripcion,
      Asiento,
      keyVuelo,
      keyAsiento,
      keyVenta
    );
    when(_checkInRepository.FindByKey(any())).thenReturn(objCheckIn);
    EditCheckInHandler handler = new EditCheckInHandler(
      _checkInFactory,
      _checkInRepository,
      _unitOfWork
    );

    CheckInDto checkInDto = new CheckInDto();
    checkInDto.setKey(objCheckIn.getKey());
    checkInDto.setCodigoSeguridad(CodigoSeguridad);
    checkInDto.setNumeroAsiento(Asiento);
    checkInDto.setEstadoPaciente(EstadoPaciente);
    checkInDto.setDescripcion(Descripcion);

    EditCheckInCommand command = new EditCheckInCommand(checkInDto.getKey());
    command.checkInDto.setCodigoSeguridad(CodigoSeguridad);
    UUID resp = handler.handle(command);
    Assert.assertEquals(objCheckIn.getKey(), resp);
  }

  @Test
  public void HandleFailed() throws Exception {
    when(_checkInRepository.FindByKey(any())).thenReturn(null);
    EditCheckInHandler handler = new EditCheckInHandler(
      _checkInFactory,
      _checkInRepository,
      _unitOfWork
    );
    CheckInDto checkInDto = new CheckInDto();
    checkInDto.setKey(UUID.randomUUID());
    checkInDto.setCodigoSeguridad(CodigoSeguridad);
    checkInDto.setNumeroAsiento(Asiento);
    checkInDto.setEstadoPaciente(EstadoPaciente);
    checkInDto.setDescripcion(Descripcion);
    EditCheckInCommand command = new EditCheckInCommand(checkInDto.getKey());
    try {
      UUID resp = handler.handle(command);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
