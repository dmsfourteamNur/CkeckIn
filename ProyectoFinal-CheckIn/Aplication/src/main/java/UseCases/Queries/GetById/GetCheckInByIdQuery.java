package UseCases.Queries.GetById;

import Dto.CheckInDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetCheckInByIdQuery implements Request<CheckInDto> {

  public UUID Key;

  public GetCheckInByIdQuery(UUID key) {
    Key = key;
  }
}
