package Model.ValueObject;

import Modal.valueObject.DescripcionEstado;
import core.BussinessRuleValidateExeption;
import org.junit.Test;

public class DescripcionEstado_Test {

  @Test
  public void Correctly() throws BussinessRuleValidateExeption {
    String Value = "tbuytuy6756";
    DescripcionEstado descripcionEstado = new DescripcionEstado(Value);
  }

  @Test
  public void Fail() throws BussinessRuleValidateExeption {
    String Value = "2 3984n23rnufh4yf37fy83ynf8347yf837yf834f834gf734gf7834gf74g3f34f3f34f43";
    DescripcionEstado descripcionEstado = new DescripcionEstado(Value);
  }
}
