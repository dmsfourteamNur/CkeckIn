package UseCases.Command.CheckIn.Create;

import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Modal.Asiento;
import Modal.CheckIn;
import Modal.Itinerario;
import Modal.Pasajero;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import Services.CheckInServices;
import core.IRepository;
import factories.ICheckInFactory;
import java.util.Iterator;
import java.util.UUID;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class CrearCheckInHandler implements RequestHandler<CrearCheckInCommand, UUID> {

  private IcheckInRepository CheckInRepository;
  private ICheckInFactory CheckInFactory;
  private CheckInServices inService;
  private IUnitOfWork _unitOfWork;
  private IcheckInRepository _checkInRepository;
  private IitinerarioRepository _IitinerarioRepository;
  private IpasajeroRepository _IpasajeroRepository;

  public CrearCheckInHandler(
    IcheckInRepository CheckInRepository,
    ICheckInFactory CheckInFactory,
    CheckInServices inService,
    IUnitOfWork _unitOfWork,
    IcheckInRepository _checkInRepository,
    IitinerarioRepository _IitinerarioRepository,
    IpasajeroRepository ipasajeroRepository
  ) {
    this.CheckInRepository = CheckInRepository;
    this.CheckInFactory = CheckInFactory;
    this.inService = inService;
    this._unitOfWork = _unitOfWork;
    this._checkInRepository = _checkInRepository;
    this._IitinerarioRepository = _IitinerarioRepository;
    this._IpasajeroRepository = ipasajeroRepository;
  }

  @Override
  public UUID handle(CrearCheckInCommand request) throws Exception {
    String nroCheckIn = inService.GenerarNroPedidoAsync();

    Pasajero pasajero = _IpasajeroRepository.FindByKeyVenta(request.checkInDto.KeyVenta);
    if (pasajero == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "LA VENTA NO EXISTE");
    }

    Pasajero pasajeroVuelo = _IpasajeroRepository.FindByKeyVuelo(request.checkInDto.KeyVuelo);
    if (pasajeroVuelo == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "EL PASAJERO NO ESTA ASIGNADO A ESTE VUELO");
    }

    Itinerario itinerario = _IitinerarioRepository.FindByKey(request.checkInDto.getKeyVuelo());
    if (itinerario == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "EL VUELO NO EXISTE");
    }

    // Asiento asiento = itinerario
    //     .getAsiento()
    //     .stream()
    //     .filter(c -> c.key.equals(request.checkInDto.getKeyAsiento()))
    //     .findAny()
    //     .orElse(null);
    // if (asiento == null) {
    //   throw new HttpException(HttpStatus.BAD_REQUEST, "EL ASIENTO NO EXISTE");
    // }

    // CheckIn checkIn = _checkInRepository
    //     .GetAll()
    //     .stream()
    //     .filter(c -> c.getKeyAsiento().equals(request.checkInDto.getKeyAsiento()))
    //     .findAny()
    //     .orElse(null);
    // if (checkIn != null) {
    //   throw new HttpException(HttpStatus.BAD_REQUEST, "EL ASIENTO YA FUE ASIGNADO");
    // }

    CheckIn objCheckIn = CheckInFactory.Create(
      nroCheckIn,
      request.checkInDto.getEstadoPaciente(),
      request.checkInDto.getDescripcion(),
      request.checkInDto.getNumeroAsiento(),
      request.checkInDto.getKeyVuelo(),
      request.checkInDto.getKeyAsiento(),
      request.checkInDto.getKeyVenta()
    );
    for (var item : request.checkInDto.EquipajeDto) {
      objCheckIn.AgregarItem(
        item.getPesoEquipaje(),
        item.getNumeroEtiqueta(),
        item.getDescripcion()
      );
    }

    objCheckIn.checkInCompletado();
    CheckInRepository.Create(objCheckIn);
    _unitOfWork.commit();
    return objCheckIn.key;
  }
}
