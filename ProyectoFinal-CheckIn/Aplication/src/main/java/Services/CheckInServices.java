package Services;

import java.util.Random;

public class CheckInServices implements IcheckInService {

  @Override
  public String GenerarNroPedidoAsync() {
    String val = "";
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      String charOrNum = random.nextInt(2) % 2 == 0 ? "Char" : "num";
      if ("char".equalsIgnoreCase(charOrNum)) {
        int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
        val += (char) (choice + random.nextInt(26));
      }
      if ("num".equalsIgnoreCase(charOrNum)) {
        val += String.valueOf(random.nextInt(10));
      }
    }
    return val;
  }
}
