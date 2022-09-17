package Modal.valueObject;

import core.BussinessRule;
import core.BussinessRuleValidateExeption;
import core.ValueObject;
import rule.StringNotNullOrEmptyRule;

public class CodigoSeguridad extends ValueObject {

  private String Value;

  public CodigoSeguridad(String value) throws BussinessRuleValidateExeption {
    CheckRule((BussinessRule) new StringNotNullOrEmptyRule(value));
    // TODO: validar el formato del numero
    Value = value;
  }
}
