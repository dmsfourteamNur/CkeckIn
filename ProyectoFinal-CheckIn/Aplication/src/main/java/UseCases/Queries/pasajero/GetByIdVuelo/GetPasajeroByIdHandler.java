package UseCases.Queries.pasajero.GetByIdVuelo;

import Dto.Asiento;
import Dto.VueloPersonaDto;
import Modal.Itinerario;
import Modal.Pasajero;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;
import java.util.ArrayList;
import java.util.List;

public class GetPasajeroByIdHandler
  implements RequestHandler<GetVueloPasajeroQuery, VueloPersonaDto> {

  private IpasajeroRepository _IpasajeroRepository;
  private IitinerarioRepository _IitinerarioRepository;

  public GetPasajeroByIdHandler(
    IpasajeroRepository ipasajeroRepository,
    IitinerarioRepository iitinerarioRepository
  ) {
    this._IpasajeroRepository = ipasajeroRepository;
    this._IitinerarioRepository = iitinerarioRepository;
  }

  @Override
  public VueloPersonaDto handle(GetVueloPasajeroQuery request) throws HttpException {
    VueloPersonaDto vueloPersonaDto = new VueloPersonaDto();
    try {
      Pasajero pasajero = _IpasajeroRepository.FindByKey(request.dni);
      if (pasajero == null) {
        return null;
      }
      Itinerario itinerario = _IitinerarioRepository.FindByKey(pasajero.getKeyVuelo());
      if (itinerario == null) {
        return null;
      }
      vueloPersonaDto.setKeyPasajero(pasajero.getKey());
      vueloPersonaDto.setKeyVuelo(pasajero.getKeyVuelo());
      vueloPersonaDto.setNombre(pasajero.getNombre());
      vueloPersonaDto.setApellido(pasajero.getApellido());
      vueloPersonaDto.setDni(pasajero.getDni());

      vueloPersonaDto.setKey(itinerario.getKey());
      vueloPersonaDto.setCiudadOrigen(itinerario.getCiudadOrigen());
      vueloPersonaDto.setCiudadDestino(itinerario.getCiudadDestino());

      List<Asiento> lista = new ArrayList<>();

      for (var item : itinerario.getAsiento()) {
        Asiento asientoDto = new Asiento();
        asientoDto.setKey(item.getKey());
        asientoDto.setNumeroAsiento(item.getNumero());
        asientoDto.setDisponibilidad(item.getDisponibilidad());
        lista.add(asientoDto);
      }
      vueloPersonaDto.setAsientos(lista);
    } catch (Exception e) {
      System.out.println(e);
    }
    return vueloPersonaDto;
  }
}
