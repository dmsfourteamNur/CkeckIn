package Application.Dto;

import Dto.CheckInDto;
import Dto.EquipajeDto;
import org.junit.Assert;
import org.junit.Test;

public class BaggageDto_Test {

  @Test
  public void CheckPropertiesValid() {
    Double PesoEquipaje = 23.3;
    String NumeroEtiqueta = "sdfsdfw";
    String Descripcion = "sdsfdsdf";

    EquipajeDto objBaggageDto = new EquipajeDto();

    Assert.assertNull(objBaggageDto.PesoEquipaje);
    Assert.assertNull(objBaggageDto.NumeroEtiqueta);
    Assert.assertNull(objBaggageDto.Descripcion);

    objBaggageDto.setPesoEquipaje(PesoEquipaje);
    objBaggageDto.setDescripcion(Descripcion);
    objBaggageDto.setNumeroEtiqueta(NumeroEtiqueta);

    Assert.assertEquals(PesoEquipaje, objBaggageDto.getPesoEquipaje());
    Assert.assertEquals(Descripcion, objBaggageDto.getDescripcion());
    Assert.assertEquals(NumeroEtiqueta, objBaggageDto.getNumeroEtiqueta());
  }
}
