package UseCases.Command.CheckIn.Edit;

import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import factories.ICheckInFactory;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class EditCheckInHandler implements RequestHandler<EditCheckInCommand, UUID> {

  private ICheckInFactory _checkInFactory;
  private IcheckInRepository _icheckInRepository;
  private IUnitOfWork _unitOfWork;

  public EditCheckInHandler(
    ICheckInFactory checkInFactory,
    IcheckInRepository icheckInRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._checkInFactory = checkInFactory;
    this._icheckInRepository = icheckInRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(EditCheckInCommand request) throws Exception {
    CheckIn checkIn = _icheckInRepository.FindByKey(request.checkInDto.getKey());
    if (checkIn == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "CheckIn no encontrada");
    }
    checkIn.CodigoSeguridad = request.checkInDto.getCodigoSeguridad();
    _icheckInRepository.Update(checkIn);
    return checkIn.key;
  }
}
