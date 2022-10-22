package Application.Dto;

import Dto.Asiento;
import Dto.ItinerarioDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class ItinerarioDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String origen = "scz";
    String destino = "lpz";
    Date fechaSalida = new Date();
    Date fechaArribe = new Date();
    List<Asiento> asientos;

    ItinerarioDto itinerarioDto = new ItinerarioDto();

    Assert.assertNull(itinerarioDto.getKey());
    Assert.assertNull(itinerarioDto.getOrigen());
    Assert.assertNull(itinerarioDto.getDestino());
    Assert.assertNull(itinerarioDto.getFechaSalida());
    Assert.assertNull(itinerarioDto.getFechaArribe());
    Assert.assertNull(itinerarioDto.getAsientos());

    itinerarioDto.setKey(key);
    itinerarioDto.setOrigen(origen);
    itinerarioDto.setDestino(destino);
    itinerarioDto.setFechaSalida(fechaSalida);
    itinerarioDto.setFechaArribe(fechaArribe);
    // itinerarioDto.setAsientos(asientos);

    Assert.assertEquals(key, itinerarioDto.getKey());
    Assert.assertEquals(origen, itinerarioDto.getOrigen());
    Assert.assertEquals(destino, itinerarioDto.getDestino());
    Assert.assertEquals(fechaSalida, itinerarioDto.getFechaSalida());
    Assert.assertEquals(fechaArribe, itinerarioDto.getFechaArribe());
  }
}
