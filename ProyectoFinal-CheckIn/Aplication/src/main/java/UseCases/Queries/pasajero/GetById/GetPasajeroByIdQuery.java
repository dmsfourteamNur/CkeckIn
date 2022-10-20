package UseCases.Queries.pasajero.GetById;

import Dto.PasajeroDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetPasajeroByIdQuery implements Request<PasajeroDto> {

  public int dni;

  public GetPasajeroByIdQuery(int dni) {
    this.dni = dni;
  }
}
