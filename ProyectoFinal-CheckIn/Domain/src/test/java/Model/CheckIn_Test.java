package Model;

import Modal.CheckIn;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CheckIn_Test {

  @Test
  public void Correctly() {
    String CodigoSeguridad = "dsfds";
    int Asiento = 33;
    Boolean EstadoPaciente = true;
    String Descripcion = "haskjhfaksjf";
    UUID keyVuelo = UUID.randomUUID();
    UUID keyAsiento = UUID.randomUUID();
    UUID keyVenta = UUID.randomUUID();

    CheckIn objCheckIn = new CheckIn(
      CodigoSeguridad,
      EstadoPaciente,
      Descripcion,
      Asiento,
      keyVuelo,
      keyAsiento,
      keyVenta
    );
    objCheckIn.AgregarItem(3.2, "Sdfds", "asdasfasa");

    CheckIn checkIn = new CheckIn();

    checkIn.setEquipaje(objCheckIn.getEquipaje());
    checkIn.setCodigoSeguridad(objCheckIn.getCodigoSeguridad());
    checkIn.setDescripcion(objCheckIn.getDescripcion());
    checkIn.setEstadoPaciente(objCheckIn.getEstadoPaciente());
    checkIn.setAsiento(objCheckIn.getAsiento());
    checkIn.setKeyVuelo(objCheckIn.getKeyVuelo());
    checkIn.setKeyAsiento(objCheckIn.getKeyAsiento());
    checkIn.setKeyVenta(objCheckIn.getKeyVenta());

    Assert.assertEquals(CodigoSeguridad, checkIn.getCodigoSeguridad());
    Assert.assertEquals(Asiento, checkIn.getAsiento());
    Assert.assertEquals(EstadoPaciente, checkIn.getEstadoPaciente());
    Assert.assertEquals(Descripcion, checkIn.getDescripcion());
    Assert.assertEquals(keyVuelo, checkIn.getKeyVuelo());
    Assert.assertEquals(keyAsiento, checkIn.getKeyAsiento());
    Assert.assertEquals(keyVenta, checkIn.getKeyVenta());

    checkIn.checkInCompletado();
  }
}
