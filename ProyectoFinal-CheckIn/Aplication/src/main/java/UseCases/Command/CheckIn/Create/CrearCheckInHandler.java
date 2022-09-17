package UseCases.Command.CheckIn.Create;

import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Services.CheckInServices;
import factories.ICheckInFactory;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class CrearCheckInHandler implements RequestHandler<CrearCheckInCommand, UUID> {

  private IcheckInRepository CheckInRepository;
  private ICheckInFactory CheckInFactory;
  private CheckInServices inService;
  private IUnitOfWork _unitOfWork;

  public CrearCheckInHandler(
    IcheckInRepository checkInRepository,
    ICheckInFactory checkInFactory,
    IUnitOfWork unitOfWork,
    CheckInServices checkInServices
  ) {
    CheckInRepository = checkInRepository;
    CheckInFactory = checkInFactory;
    _unitOfWork = unitOfWork;
    inService = checkInServices;
  }

  @Override
  public UUID handle(CrearCheckInCommand request) throws Exception {
    String nroCheckIn = inService.GenerarNroPedidoAsync();
    CheckIn objCheckIn = CheckInFactory.Create(
      nroCheckIn,
      request.checkInDto.getEstadoPaciente(),
      request.checkInDto.getDescripcion(),
      request.checkInDto.getNumeroAsiento(),
      request.checkInDto.getKeyVuelo(),
      request.checkInDto.getKeyPasajero()
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
