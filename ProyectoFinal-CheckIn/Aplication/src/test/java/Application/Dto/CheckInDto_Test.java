package Application.Dto;

import Dto.CheckInDto;
import Dto.EquipajeDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CheckInDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID keyTest = UUID.randomUUID();
    String CodigoSeguridadTest = "daf32sdf";
    Date HoraCheckInTest = new Date();
    Boolean EstadoPacienteTest = false;
    String DescripcionTest = "sdfdsf";
    int AsientoTest = 23;
    List<EquipajeDto> BaggageDtoTest = getBaggage();

    CheckInDto objCheckIn = new CheckInDto();

    Assert.assertEquals(null, objCheckIn.Key);
    Assert.assertNull(objCheckIn.CodigoSeguridad);
    Assert.assertNull(objCheckIn.HoraCheckIn);
    Assert.assertNull(objCheckIn.EstadoPaciente);
    Assert.assertNull(objCheckIn.Descripcion);
    Assert.assertEquals(0, objCheckIn.NumeroAsiento);
    Assert.assertEquals(null, objCheckIn.EquipajeDto);

    objCheckIn.setKey(keyTest);
    objCheckIn.setCodigoSeguridad(CodigoSeguridadTest);
    objCheckIn.setHoraCheckIn(HoraCheckInTest);
    objCheckIn.setEstadoPaciente(EstadoPacienteTest);
    objCheckIn.setDescripcion(DescripcionTest);
    objCheckIn.setNumeroAsiento(AsientoTest);
    objCheckIn.setEquipajeDto(BaggageDtoTest);

    Assert.assertEquals(keyTest, objCheckIn.getKey());
    Assert.assertEquals(CodigoSeguridadTest, objCheckIn.getCodigoSeguridad());
    Assert.assertEquals(HoraCheckInTest, objCheckIn.getHoraCheckIn());
    Assert.assertEquals(EstadoPacienteTest, objCheckIn.getEstadoPaciente());
    Assert.assertEquals(DescripcionTest, objCheckIn.getDescripcion());
    Assert.assertEquals(AsientoTest, objCheckIn.getNumeroAsiento());
    Assert.assertEquals(BaggageDtoTest, objCheckIn.getEquipajeDto());
  }

  private List<EquipajeDto> getBaggage() {
    ArrayList list = new ArrayList();
    EquipajeDto baggageDto = new EquipajeDto();
    baggageDto.setNumeroEtiqueta("dsdfsdf");
    baggageDto.setDescripcion("dsfdsf");
    baggageDto.setPesoEquipaje(23.3);
    list.add(baggageDto);
    return list;
  }
}
