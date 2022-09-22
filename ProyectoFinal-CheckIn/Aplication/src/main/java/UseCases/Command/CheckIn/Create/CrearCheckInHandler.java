package UseCases.Command.CheckIn.Create;

import Modal.Asiento;
import Modal.CheckIn;
import Modal.Itinerario;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Repositories.IitinerarioRepository;
import Services.CheckInServices;
import core.IRepository;
import factories.ICheckInFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
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

  public CrearCheckInHandler(IcheckInRepository CheckInRepository, ICheckInFactory CheckInFactory,
      CheckInServices inService, IUnitOfWork _unitOfWork, IcheckInRepository _checkInRepository,
      IitinerarioRepository _IitinerarioRepository) {
    this.CheckInRepository = CheckInRepository;
    this.CheckInFactory = CheckInFactory;
    this.inService = inService;
    this._unitOfWork = _unitOfWork;
    this._checkInRepository = _checkInRepository;
    this._IitinerarioRepository = _IitinerarioRepository;
  }

  @Override
  public UUID handle(CrearCheckInCommand request) throws Exception {
    String nroCheckIn = inService.GenerarNroPedidoAsync();

    Itinerario itinerario = _IitinerarioRepository.FindByKey(request.checkInDto.getKeyVuelo());
    if (itinerario == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "EL VUELO NO EXISTE");
    }

    Asiento asiento = itinerario.getAsiento().stream()
        .filter(c -> c.key.equals(request.checkInDto.getKeyAsiento()))
        .findAny().orElse(null);
    if (asiento == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "EL ASIENTO NO EXISTE");
    }

    CheckIn checkIn = _checkInRepository.GetAll().stream()
        .filter(c -> c.getKeyAsiento().equals(request.checkInDto.getKeyAsiento()))
        .findAny().orElse(null);
    if (checkIn != null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "EL ASIENTO YA FUE ASIGNADO");
    }

    CheckIn objCheckIn = CheckInFactory.Create(
        nroCheckIn,
        request.checkInDto.getEstadoPaciente(),
        request.checkInDto.getDescripcion(),
        request.checkInDto.getNumeroAsiento(),
        request.checkInDto.getKeyVuelo(),
        request.checkInDto.getKeyAsiento());
    for (var item : request.checkInDto.EquipajeDto) {
      objCheckIn.AgregarItem(
          item.getPesoEquipaje(),
          item.getNumeroEtiqueta(),
          item.getDescripcion());
    }

    objCheckIn.checkInCompletado();
    CheckInRepository.Create(objCheckIn);
    _unitOfWork.commit();
    return objCheckIn.key;
  }
}
