package UseCases.Queries.pasajero.GetById;

import java.util.UUID;

import Dto.PasajeroDto;
import Fourteam.mediator.Request;

public class GetPasajeroByIdQuery implements Request<PasajeroDto> {

  public UUID keyVenta;

  public GetPasajeroByIdQuery(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }
}
