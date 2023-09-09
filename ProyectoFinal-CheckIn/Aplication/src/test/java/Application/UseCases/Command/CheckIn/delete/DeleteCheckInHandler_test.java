package Application.UseCases.Command.CheckIn.delete;

import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;
import UseCases.Command.CheckIn.Delete.DeleteCheckInHandler;

public class DeleteCheckInHandler_test {

  private IcheckInRepository icheckInRepository;
  private IUnitOfWork unitOfWork;
  private DeleteCheckInHandler handler;

  @Before
  public void setUp() throws Exception {
    icheckInRepository = Mockito.mock(IcheckInRepository.class);
    unitOfWork = Mockito.mock(IUnitOfWork.class);
    handler = new DeleteCheckInHandler(icheckInRepository, unitOfWork);
  }

  @Test
  public void handle_CheckInExists_DeletesCheckInAndCommitsUnitOfWork() throws Exception {
    UUID key = UUID.randomUUID();
    CheckIn checkIn = new CheckIn();
    checkIn.key = key;
    when(icheckInRepository.FindByKey(key)).thenReturn(checkIn);
    DeleteCheckInCommand command = new DeleteCheckInCommand(key);
    UUID result = handler.handle(command);
    Assert.assertNotNull(result);
    Assert.assertEquals(key, result);
    Mockito.verify(icheckInRepository, Mockito.times(1)).Delete(checkIn);
    Mockito.verify(unitOfWork, Mockito.times(1)).commit();
  }

  @Test
  public void handle_CheckInNotExists_ThrowsHttpException() throws Exception {
    UUID key = UUID.randomUUID();
    when(icheckInRepository.FindByKey(key)).thenReturn(null);
    DeleteCheckInCommand command = new DeleteCheckInCommand(key);
    handler.handle(command);
  }
}
