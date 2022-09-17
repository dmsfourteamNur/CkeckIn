package UseCases.Queries.pasajero.GetById;

import Dto.PasajeroDto;
import Modal.Pasajero;
import Repositories.IpasajeroRepository;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class GetPasajeroByIdHandler implements RequestHandler<GetPasajeroByIdQuery, PasajeroDto> {

  private IpasajeroRepository _IpasajeroRepository;

  public GetPasajeroByIdHandler(IpasajeroRepository ipasajeroRepository) {
    this._IpasajeroRepository = ipasajeroRepository;
  }

  @Override
  public PasajeroDto handle(GetPasajeroByIdQuery request) throws HttpException {
    PasajeroDto pasajeroDto = new PasajeroDto();
    try {
      Pasajero pasajero = _IpasajeroRepository.FindByKey(request.Dni);
      if (pasajero == null) {
        return null;
      }
      pasajeroDto.setKeyVuelo(pasajero.getKey());
      pasajeroDto.setNombre(pasajero.getnombre());
      pasajeroDto.setApellido(pasajero.getapellido());
      pasajeroDto.setDni(pasajero.getDni());
    } catch (Exception e) {
      System.out.println(e);
    }
    return pasajeroDto;
  }
}
