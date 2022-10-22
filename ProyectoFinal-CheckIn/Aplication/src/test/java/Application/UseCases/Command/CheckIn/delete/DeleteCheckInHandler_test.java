package Application.UseCases.Command.CheckIn.delete;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Dto.CheckInDto;
import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;
import UseCases.Command.CheckIn.Delete.DeleteCheckInHandler;
import factories.ICheckInFactory;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DeleteCheckInHandler_test {

  ICheckInFactory checkInFactory = Mockito.mock(ICheckInFactory.class);
  IcheckInRepository icheckInRepository = Mockito.mock(IcheckInRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    UUID id = UUID.randomUUID();
    CheckIn a = new CheckIn();
    a.key = id;

    when(icheckInRepository.FindByKey(any())).thenReturn(a);
    when(icheckInRepository.Delete(any())).thenReturn(a);

    DeleteCheckInHandler handler = new DeleteCheckInHandler(
      checkInFactory,
      icheckInRepository,
      _unitOfWork
    );

    CheckInDto checkInDto = new CheckInDto();
    checkInDto.Key = id;
    DeleteCheckInCommand command = new DeleteCheckInCommand(checkInDto.getKey());
    UUID resp = handler.handle(command);
    Assert.assertEquals(a.key, resp);
  }
}
