import org.junit.Assert;
import org.junit.Test;

public class ExtensionInfraestructure_Test {

  @Test
  public void Infraestructure_Ok() {
    ExtensionsInfrastructure infraestructure = new ExtensionsInfrastructure();
    Assert.assertNotNull(infraestructure);
  }
}
