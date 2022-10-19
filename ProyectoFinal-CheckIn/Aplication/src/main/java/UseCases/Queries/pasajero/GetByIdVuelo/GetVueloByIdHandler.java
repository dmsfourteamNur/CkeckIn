package UseCases.Queries.pasajero.GetByIdVuelo;

import Dto.Asiento;
import Dto.VueloPersonaDto;
import Modal.Itinerario;
import Modal.Pasajero;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import java.util.ArrayList;
import java.util.List;

public class GetVueloByIdHandler
    implements RequestHandler<GetVueloPasajeroQuery, VueloPersonaDto> {

  private IpasajeroRepository _IpasajeroRepository;
  private IitinerarioRepository _IitinerarioRepository;

  public GetVueloByIdHandler(
      IpasajeroRepository ipasajeroRepository,
      IitinerarioRepository iitinerarioRepository) {
    this._IpasajeroRepository = ipasajeroRepository;
    this._IitinerarioRepository = iitinerarioRepository;
  }

  @Override
  public VueloPersonaDto handle(GetVueloPasajeroQuery request) throws HttpException {
    VueloPersonaDto vueloPersonaDto = new VueloPersonaDto();
    try {
      Pasajero pasajero = _IpasajeroRepository.FindByKeyPasajero(request.dni);
      if (pasajero == null) {
        throw new HttpException(HttpStatus.BAD_REQUEST, "NO EXISTE EL PASAJERO");
      }
      Itinerario itinerario = _IitinerarioRepository.FindByKey(pasajero.getKey());
      if (itinerario == null) {
        throw new HttpException(HttpStatus.BAD_REQUEST, "EL PASAJERO NO TIENE ASIGNADO NINGUN VUELO");
      }
      vueloPersonaDto.setKeyVenta(pasajero.getKey());
      vueloPersonaDto.setKeyVuelo(pasajero.getKey());
      vueloPersonaDto.setNombre(pasajero.getNombre());
      vueloPersonaDto.setApellido(pasajero.getApellido());
      vueloPersonaDto.setDni(pasajero.getDni());
      vueloPersonaDto.setOrigen(itinerario.getOrigen());
      vueloPersonaDto.setDestino(itinerario.getDestino());
      vueloPersonaDto.setFechaSalida(itinerario.getFechaSalida());
      vueloPersonaDto.setFechaArribe(itinerario.getFechaArribe());

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
