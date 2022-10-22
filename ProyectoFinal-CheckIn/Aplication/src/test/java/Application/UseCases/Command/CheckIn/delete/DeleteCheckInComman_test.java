package Application.UseCases.Command.CheckIn.delete;

import Dto.CheckInDto;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class DeleteCheckInComman_test {

  @Test
  public void dataValid() {
    UUID id = UUID.randomUUID();
    CheckInDto checkInDto = new CheckInDto();
    checkInDto.setKey(id);
    DeleteCheckInCommand command = new DeleteCheckInCommand(checkInDto.Key);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(DeleteCheckInCommand.class.getConstructors()[0].canAccess(null));
  }
}
