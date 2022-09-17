package UseCases.Queries.pasajero.GetById;

import Dto.PasajeroDto;
import fourteam.mediator.Request;

public class GetPasajeroByIdQuery implements Request<PasajeroDto> {

  public int Dni;

  public GetPasajeroByIdQuery(int Dni) {
    this.Dni = Dni;
  }
}
