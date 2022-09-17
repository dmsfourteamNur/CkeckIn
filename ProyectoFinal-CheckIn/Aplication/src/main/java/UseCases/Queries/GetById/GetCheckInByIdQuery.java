package UseCases.Queries.GetById;

import Dto.CheckInDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class GetCheckInByIdQuery implements Request<CheckInDto> {

  public UUID Key;

  public GetCheckInByIdQuery(UUID key) {
    Key = key;
  }
}
