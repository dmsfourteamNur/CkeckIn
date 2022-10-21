package Application.UseCases.Command.CheckIn.Create;

import Dto.CheckInDto;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import org.junit.Assert;
import org.junit.Test;

public class CrearCheckInCommand_Test {

  @Test
  public void dataValid() {
    String descripcion = "HOlaa";
    CheckInDto checkInDto = new CheckInDto();
    checkInDto.setDescripcion(descripcion);
    CrearCheckInCommand command = new CrearCheckInCommand(checkInDto);
    Assert.assertEquals(descripcion, command.checkInDto.getDescripcion());
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(CrearCheckInCommand.class.getConstructors()[0].canAccess(null));
  }
}
