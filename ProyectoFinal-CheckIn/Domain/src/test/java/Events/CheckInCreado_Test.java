package Events;

import Fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

public class CheckInCreado_Test {

  @Before
  public void setup() {}

  @Test
  public void HandleCheckInRegistrado_Ok() throws HttpException {
    UUID KeyCheckIn = UUID.randomUUID();
    String CodigoSeguridad = "sdfdsf";

    CheckInCreado personalRegistradoTest = new CheckInCreado(KeyCheckIn, CodigoSeguridad);

    personalRegistradoTest.CodigoSeguridad = CodigoSeguridad;
    String codigo = personalRegistradoTest.CodigoSeguridad;
  }
}
