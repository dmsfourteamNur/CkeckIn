package Application.UseCases.Command.CheckIn.Create;

import static org.mockito.Mockito.*;

import Dto.CheckInDto;
import Dto.EquipajeDto;
import Events.CheckInCreado;
import Modal.CheckIn;
import Modal.Itinerario;
import Modal.Pasajero;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import Services.CheckInServices;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import UseCases.Command.CheckIn.Create.CrearCheckInHandler;
import factories.CheckInFactory;
import factories.ICheckInFactory;
import factories.pasajero.PasajeroFactory;
import java.util.ArrayList;
import java.util.Date;
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

    String nombre = "Juancito";
    String apellido = "Perez";
    int dni = 9782736;

    Pasajero p = new Pasajero(keyVuelo, keyVenta, nombre, apellido, dni);
    when(ipasajeroRepository.FindByKeyVenta(any())).thenReturn(p);
    when(ipasajeroRepository.FindByKeyVuelo(any())).thenReturn(p);

    String origen = "scz";
    String destino = "lpz";
    Date fechaSalida = new Date();
    Date fechaArribe = new Date();
    Itinerario itinerario = new Itinerario(keyVuelo, origen, destino, fechaSalida, fechaArribe);
    when(iitinerarioRepository.FindByKey(any())).thenReturn(itinerario);

    CrearCheckInHandler handler = new CrearCheckInHandler(
      checkInFactory,
      checkInServices,
      _unitOfWork,
      checkInRepository,
      iitinerarioRepository,
      ipasajeroRepository
    );

    CheckInDto checkInDto = new CheckInDto();
    checkInDto.CodigoSeguridad = CodigoSeguridad;
    checkInDto.NumeroAsiento = Asiento;
    checkInDto.EstadoPaciente = EstadoPaciente;
    checkInDto.Descripcion = Descripcion;
    checkInDto.EquipajeDto = Equipaje;
    checkInDto.KeyVuelo = keyVuelo;
    checkInDto.KeyVenta = keyVenta;
    checkInDto.KeyAsiento = keyAsiento;

    CrearCheckInCommand objRequest = new CrearCheckInCommand(checkInDto);
    var resp = handler.handle(objRequest);

    verify(_unitOfWork).commit();
    Assert.assertNotNull(resp);

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
