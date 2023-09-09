package Application.UseCases.Command.CheckIn.delete;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import Dto.CheckInDto;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;

public class DeleteCheckInComman_test {

  @Test
  public void constructorSetsCheckInDto() throws Exception {
    UUID key = UUID.randomUUID();
    CheckInDto Dto = new CheckInDto();
    Dto.Key = key;

    DeleteCheckInCommand command = new DeleteCheckInCommand(Dto.Key);
    Assert.assertEquals(Dto.Key, command.checkInDto.Key);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(DeleteCheckInCommand.class.getConstructors()[0].canAccess(null));
  }
}
