package UseCases.Queries.pasajero.GetByIdVuelo;

import java.util.UUID;

import Dto.VueloPersonaDto;
import Fourteam.mediator.Request;

public class GetVueloPasajeroQuery implements Request<VueloPersonaDto> {

  public UUID keyVenta;

  public GetVueloPasajeroQuery(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }
}
