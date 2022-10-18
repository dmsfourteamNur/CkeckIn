import Controllers.CheckInController;
import Fourteam.config.Config;
import Fourteam.http.Rest;

public class ExtensionsWebApi {

  public static void AddControllers() {
    Rest.addController(CheckInController.class);
    Rest.start(Integer.parseInt(Config.getProperty("http.port")));
    Rest.createSwagger();
  }
}
