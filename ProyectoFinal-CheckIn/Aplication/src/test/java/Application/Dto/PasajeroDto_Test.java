package Application.Dto;

import Dto.Asiento;
import Dto.ItinerarioDto;
import Dto.PasajeroDto;
import Modal.Pasajero;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class PasajeroDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID keyVenta = UUID.randomUUID();
    UUID keyVuelo = UUID.randomUUID();
    String nombre = "Juancito";
    String apellido = "Perez";
    int dni = 9782736;

    PasajeroDto pasajeroDto = new PasajeroDto();

    Assert.assertNull(pasajeroDto.getDni());
    Assert.assertNull(pasajeroDto.getKeyVenta());
    Assert.assertNull(pasajeroDto.getKeyVuelo());
    Assert.assertNull(pasajeroDto.getNombre());
    Assert.assertNull(pasajeroDto.getApellido());

    pasajeroDto.setDni(dni);
    pasajeroDto.setKeyVuelo(keyVuelo);
    pasajeroDto.setKeyVenta(keyVenta);
    pasajeroDto.setNombre(nombre);
    pasajeroDto.setApellido(apellido);

    Assert.assertEquals(dni, pasajeroDto.getDni());
    Assert.assertEquals(nombre, pasajeroDto.getNombre());
    Assert.assertEquals(apellido, pasajeroDto.getApellido());
    Assert.assertEquals(keyVenta, pasajeroDto.getKeyVenta());
    Assert.assertEquals(keyVuelo, pasajeroDto.getKeyVuelo());
  }
}
