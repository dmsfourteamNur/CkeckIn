package Model;

import Modal.Asiento;
import Modal.Itinerario;
import Modal.Pasajero;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class Itinerario_Test {

  @Test
  public void Correctly() {
    String origen = "LPZ";
    String destino = "SCZ";
    Date fechaSalida = new Date();
    Date fechaArribe = new Date();
    List<Asiento> asiento;

    Itinerario itinerario = new Itinerario(
      UUID.randomUUID(),
      origen,
      destino,
      fechaSalida,
      fechaArribe
    );

    itinerario.setDestino(destino);
    itinerario.setOrigen(origen);
    itinerario.setFechaSalida(fechaSalida);
    itinerario.setFechaArribe(fechaArribe);

    Assert.assertEquals(origen, itinerario.getOrigen());
    Assert.assertEquals(destino, itinerario.getDestino());
    Assert.assertEquals(fechaSalida, itinerario.getFechaSalida());
    Assert.assertEquals(fechaArribe, itinerario.getFechaArribe());
  }
}
