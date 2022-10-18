package factories;

import Modal.CheckIn;
import java.util.UUID;

public class CheckInFactory implements ICheckInFactory {

  @Override
  public CheckIn Create(
      String codigoSeguridad,
      Boolean estadoPaciente,
      String descripcion,
      int numeroAsiento,
      UUID keyVuelo,
      UUID keyAsiento) {
    return new CheckIn(codigoSeguridad, estadoPaciente, descripcion, numeroAsiento, keyVuelo, keyAsiento);
  }
}
