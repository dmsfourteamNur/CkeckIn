import Controllers.CheckInController;
import fourteam.config.Config;
import fourteam.http.Rest;

public class ExtensionsWebApi {

  public static void AddControllers() {
    Rest.addController(CheckInController.class);
    Rest.start(Integer.parseInt(Config.getProperty("http.port")));
    // Rest.createSwagger();
  }
}
