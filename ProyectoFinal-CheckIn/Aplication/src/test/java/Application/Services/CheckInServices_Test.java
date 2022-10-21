package Application.Services;

import Services.CheckInServices;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CheckInServices_Test {

  @DataPoint
  public static String nro = null;

  @DataPoint
  public static String nro2 = null;

  @DataPoint
  public static String nro3 = null;

  @DataPoint
  public static String nro5 = null;

  //@Test
  @Theory
  public void CheckValidateNroCheckIn(String nro) {
    CheckInServices checkInServices = new CheckInServices();
    String nroCheckIn = checkInServices.GenerarNroPedidoAsync();
    Assert.assertNotEquals(nro, nroCheckIn);
  }
}
