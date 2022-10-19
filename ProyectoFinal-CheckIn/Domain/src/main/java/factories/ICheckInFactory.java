package factories;

import Modal.CheckIn;
import java.util.UUID;

public interface ICheckInFactory {
  CheckIn Create(
      String codigoSeguridad,
      Boolean estadoPaciente,
      String descripcion,
      int asiento,
      UUID keyVuelo,
      UUID keyAsiento,
      UUID keyVenta);
}
