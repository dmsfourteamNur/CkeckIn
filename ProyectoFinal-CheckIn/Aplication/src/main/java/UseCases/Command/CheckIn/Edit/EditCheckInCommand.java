package UseCases.Command.CheckIn.Edit;

import Dto.CheckInDto;
import Fourteam.mediator.Request;
import Modal.CheckIn;
import java.util.UUID;

public class EditCheckInCommand implements Request<UUID> {

  public CheckInDto checkInDto;

  public EditCheckInCommand(UUID key) {
    this.checkInDto = new CheckInDto();
    this.checkInDto.Key = key;
  }
}
