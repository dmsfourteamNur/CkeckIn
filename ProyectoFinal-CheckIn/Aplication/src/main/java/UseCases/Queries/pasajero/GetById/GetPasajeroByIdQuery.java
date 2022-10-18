package UseCases.Queries.pasajero.GetById;

import java.util.UUID;

import Dto.PasajeroDto;
import Fourteam.mediator.Request;

public class GetPasajeroByIdQuery implements Request<PasajeroDto> {

  public int dni;

  public GetPasajeroByIdQuery(int dni) {
    this.dni = dni;
  }
}
