package UseCases.Command.CheckIn.Delete;

import Dto.CheckInDto;
import Fourteam.mediator.Request;
import Modal.CheckIn;
import java.util.UUID;

public class DeleteCheckInCommand implements Request<UUID> {

  CheckInDto checkInDto;

  public DeleteCheckInCommand(UUID key) {
    this.checkInDto = new CheckInDto();
    this.checkInDto.Key = key;
  }
}
