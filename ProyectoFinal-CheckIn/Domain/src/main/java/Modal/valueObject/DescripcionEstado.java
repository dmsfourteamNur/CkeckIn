package Modal.valueObject;

import core.BussinessRuleValidateExeption;
import core.ValueObject;
import rule.StringNotNullOrEmptyRule;

public class DescripcionEstado extends ValueObject {

  private String Value;

  public DescripcionEstado(String value) throws BussinessRuleValidateExeption {
    if (value.length() > 50) {
      throw new BussinessRuleValidateExeption("No debe ser mayor a 50 caracteres");
    }
    Value = value;
  }
}
