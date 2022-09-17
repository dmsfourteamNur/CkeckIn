package UseCases.Queries.pasajero.GetByIdVuelo;

import Dto.VueloPersonaDto;
import Fourteam.mediator.Request;

public class GetVueloPasajeroQuery implements Request<VueloPersonaDto> {

  public int dni;

  public GetVueloPasajeroQuery(int dni) {
    this.dni = dni;
  }
}
