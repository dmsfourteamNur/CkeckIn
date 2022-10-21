package Application.UseCases.Command.CheckIn.Create;

import static org.mockito.Mockito.*;

import Dto.CheckInDto;
import Dto.EquipajeDto;
import Events.CheckInCreado;
import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import Services.CheckInServices;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import UseCases.Command.CheckIn.Create.CrearCheckInHandler;
import factories.CheckInFactory;
import factories.ICheckInFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearCheckInHandler_Test {

  ICheckInFactory checkInFactory = Mockito.mock(ICheckInFactory.class);
  IcheckInRepository checkInRepository = Mockito.mock(IcheckInRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);
  CheckInServices checkInServices = Mockito.mock(CheckInServices.class);
  IitinerarioRepository iitinerarioRepository = Mockito.mock(IitinerarioRepository.class);
  IpasajeroRepository ipasajeroRepository = Mockito.mock(IpasajeroRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    String CodigoSeguridad = "dsfds";
    int Asiento = 33;
    Boolean EstadoPaciente = true;
    String Descripcion = "haskjhfaksjf";
    UUID keyVuelo = UUID.randomUUID();
    UUID keyAsiento = UUID.randomUUID();
    UUID keyVenta = UUID.randomUUID();

    List<EquipajeDto> Equipaje = getBaggage();

    when(checkInServices.GenerarNroPedidoAsync()).thenReturn(CodigoSeguridad);
    CheckIn objCheckIn = new CheckInFactory()
      .Create(
        CodigoSeguridad,
        EstadoPaciente,
        Descripcion,
        Asiento,
        keyVuelo,
        keyAsiento,
        keyVenta
      );
    when(
      checkInFactory.Create(anyString(), anyBoolean(), anyString(), anyInt(), any(), any(), any())
    )
      .thenReturn(objCheckIn);

    CrearCheckInHandler handler = new CrearCheckInHandler(
      checkInRepository,
      checkInFactory,
      checkInServices,
      _unitOfWork,
      checkInRepository,
      iitinerarioRepository,
      ipasajeroRepository
    );

    CheckInDto checkInDto = new CheckInDto();
    checkInDto.setCodigoSeguridad(CodigoSeguridad);
    checkInDto.setNumeroAsiento(Asiento);
    checkInDto.setEstadoPaciente(EstadoPaciente);
    checkInDto.setDescripcion(Descripcion);
    checkInDto.setEquipajeDto(Equipaje);
    checkInDto.setKeyVuelo(keyVuelo);
    checkInDto.setKeyVenta(keyVenta);
    checkInDto.setKeyAsiento(keyAsiento);

    var objRequest = new CrearCheckInCommand(checkInDto);
    var resp = handler.handle(objRequest);

    verify(checkInRepository.FindByKey(resp));
    verify(_unitOfWork).commit();
    verify(checkInServices).GenerarNroPedidoAsync();

    Assert.assertEquals(CheckInCreado.class, objCheckIn.domainEvents.get(0).getClass());
  }

  private List<EquipajeDto> getBaggage() {
    List<EquipajeDto> list = new ArrayList();
    EquipajeDto baggageDto = new EquipajeDto();
    baggageDto.setNumeroEtiqueta("dsdfsdf");
    baggageDto.setDescripcion("dsfdsf");
    baggageDto.setPesoEquipaje(23.3);
    list.add(baggageDto);
    return list;
  }
}
