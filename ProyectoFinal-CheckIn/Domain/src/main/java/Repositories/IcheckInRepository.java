package Repositories;

import Modal.CheckIn;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IcheckInRepository extends IRepository<CheckIn, UUID> {
  // public void UpdateAsync(CheckIn obj);

  public List<CheckIn> GetAll() throws Exception;

  public CheckIn Delete(CheckIn checkIn) throws Exception;

  public CheckIn Update(CheckIn checkIn) throws Exception;
}
