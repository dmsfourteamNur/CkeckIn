package UseCases.Queries.pasajero.GetById;

import Dto.PasajeroDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Modal.Pasajero;
import Repositories.IpasajeroRepository;

public class GetPasajeroByIdHandler implements RequestHandler<GetPasajeroByIdQuery, PasajeroDto> {

  private IpasajeroRepository _IpasajeroRepository;

  public GetPasajeroByIdHandler(IpasajeroRepository ipasajeroRepository) {
    this._IpasajeroRepository = ipasajeroRepository;
  }

  @Override
  public PasajeroDto handle(GetPasajeroByIdQuery request) throws HttpException {
    PasajeroDto pasajeroDto = new PasajeroDto();
    try {
      // Pasajero pasajero = _IpasajeroRepository.FindByKeyVenta(request.keyVenta);
      Pasajero pasajero = _IpasajeroRepository.FindByKeyPasajero(request.dni);
      if (pasajero == null) {
        return null;
      }
      pasajeroDto.setKeyVenta(pasajero.getKey());
      pasajeroDto.setKeyVuelo(pasajero.getKeyVenta());
      pasajeroDto.setNombre(pasajero.getNombre());
      pasajeroDto.setApellido(pasajero.getApellido());
      pasajeroDto.setDni(pasajero.getDni());
    } catch (Exception e) {
      System.out.println(e);
    }
    return pasajeroDto;
  }
}
