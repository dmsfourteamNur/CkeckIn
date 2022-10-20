package UseCases.Queries.GetById;

import Dto.CheckInDto;
import Dto.EquipajeDto;
import Fourteam.mediator.RequestHandler;
import Modal.CheckIn;
import Repositories.IcheckInRepository;
import java.util.ArrayList;
import java.util.List;

public class GetCheckInByIdHandler implements RequestHandler<GetCheckInByIdQuery, CheckInDto> {

  private IcheckInRepository _IcheckInRepository;

  public GetCheckInByIdHandler(IcheckInRepository icheckInRepository) {
    this._IcheckInRepository = icheckInRepository;
  }

  @Override
  public CheckInDto handle(GetCheckInByIdQuery request) {
    CheckInDto checkInDto = new CheckInDto();
    try {
      CheckIn checkIn = _IcheckInRepository.FindByKey(request.Key);
      if (checkIn == null) {
        return null;
      }
      checkInDto.setEstadoPaciente(checkIn.getEstadoPaciente());
      checkInDto.setDescripcion(checkIn.getDescripcion());
      checkInDto.setNumeroAsiento(checkIn.getAsiento());
      checkInDto.setKeyVuelo(checkIn.getKeyVuelo());
      List<EquipajeDto> lista = new ArrayList<>();
      for (var item : checkIn.getEquipaje()) {
        EquipajeDto equipajeDto = new EquipajeDto();
        equipajeDto.setPesoEquipaje(item.getPesoEquipaje());
        equipajeDto.setNumeroEtiqueta(item.getNumeroEtiquta());
        equipajeDto.setDescripcion(item.getDescripcion());
        lista.add(equipajeDto);
      }
      checkInDto.setEquipajeDto(lista);
      checkInDto.setCodigoSeguridad(checkIn.getCodigoSeguridad());
    } catch (Exception e) {
      System.out.println(e);
    }
    return checkInDto;
  }
}
