package Controllers;

import Dto.CheckInDto;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;
import UseCases.Command.CheckIn.Edit.EditCheckInCommand;
import UseCases.Queries.GetAll.GetCheckInAllQuery;
import UseCases.Queries.GetById.GetCheckInByIdQuery;
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

  @PostMapping("/registro")
  public String register(@RequestBody CrearCheckInCommand checkInCommand) throws Exception {
    return "hola ";
    // return (UUID) _mediator.send(checkInCommand).data;
  }

  @GetMapping("/")
  public List<CheckInDto> getAll() throws Exception {
    return (List<CheckInDto>) _mediator.send(new GetCheckInAllQuery()).data;
  }

  @PutMapping("/{key}")
  public CheckInDto edit(
    @RequestBody CheckInDto checkInDto,
    @PathVariable EditCheckInCommand request
  ) throws Exception {
    request.checkInDto.CodigoSeguridad = checkInDto.CodigoSeguridad;
    return (CheckInDto) _mediator.send(request).data;
  }

  @DeleteMapping("/{key}")
  public UUID delete(@PathVariable DeleteCheckInCommand request) throws Exception {
    return (UUID) _mediator.send(request).data;
  }
}
