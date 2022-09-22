package Controllers;

import Dto.CheckInDto;
import Dto.PasajeroDto;
import Dto.VueloPersonaDto;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;
import UseCases.Command.CheckIn.Edit.EditCheckInCommand;
import UseCases.Queries.GetAll.GetCheckInAllQuery;
import UseCases.Queries.GetAllVenta.GetpasajeroAllQuery;
import UseCases.Queries.GetById.GetCheckInByIdQuery;
import UseCases.Queries.pasajero.GetById.GetPasajeroByIdQuery;
import UseCases.Queries.pasajero.GetByIdVuelo.GetVueloPasajeroQuery;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

  private Mediator _mediator;

  public CheckInController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/{key}")
  public CheckInDto getByKey(@PathVariable GetCheckInByIdQuery request) throws Exception {
    return (CheckInDto) _mediator.send(request).data;
  }

  @GetMapping("/venta/{key}")
  public PasajeroDto getByKeyVenta(@PathVariable GetPasajeroByIdQuery request) throws Exception {
    return (PasajeroDto) _mediator.send(request).data;
  }

  @GetMapping("/vuelo/{key}")
  public VueloPersonaDto getByKeyVuelo(@PathVariable GetVueloPasajeroQuery request) throws Exception {
    return (VueloPersonaDto) _mediator.send(request).data;
  }

  @PostMapping("/registro")
  public UUID register(@RequestBody CrearCheckInCommand checkInCommand) throws Exception {
    return (UUID) _mediator.send(checkInCommand).data;
  }

  @GetMapping("/")
  public List<CheckInDto> getAll() throws Exception {
    return (List<CheckInDto>) _mediator.send(new GetCheckInAllQuery()).data;
  }

  @GetMapping("/venta")
  public List<PasajeroDto> getAllVenta() throws Exception {
    return (List<PasajeroDto>) _mediator.send(new GetpasajeroAllQuery()).data;
  }

  @PutMapping("/{key}")
  public CheckInDto edit(
      @RequestBody CheckInDto checkInDto,
      @PathVariable EditCheckInCommand request) throws Exception {
    request.checkInDto.CodigoSeguridad = checkInDto.CodigoSeguridad;
    return (CheckInDto) _mediator.send(request).data;
  }

  @DeleteMapping("/{key}")
  public UUID delete(@PathVariable DeleteCheckInCommand request) throws Exception {
    return (UUID) _mediator.send(request).data;
  }
}
