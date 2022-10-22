package Model.ValueObject;

import Modal.valueObject.CodigoSeguridad;
import core.BussinessRuleValidateExeption;
import org.junit.Test;

public class CodigoSeguridad_Test {

  @Test
  public void Correctly() throws BussinessRuleValidateExeption {
    String Value = "tbuytuy6756";
    CodigoSeguridad codigoSeguridad = new CodigoSeguridad(Value);
  }
}
