package UseCases.Command.CheckIn.Delete;

import Dto.CheckInDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class DeleteCheckInCommand implements Request<CheckInDto> {

  public CheckInDto checkInDto;

  public DeleteCheckInCommand(UUID key) {
    this.checkInDto = new CheckInDto();
    this.checkInDto.Key = key;
  }
}
