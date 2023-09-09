package UseCases.Command.CheckIn.Create;

import Dto.CheckInDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class CrearCheckInCommand implements Request<CheckInDto> {

  public CheckInDto checkInDto;

  public CrearCheckInCommand(CheckInDto obj) {
    checkInDto = obj;
  }

  public CheckInDto getCheckInDto() {
    return this.checkInDto;
  }

  public void setCheckInDto(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
