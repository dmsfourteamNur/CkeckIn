import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDB.*;
import EF.Repository.CheckInRepository;
import EF.Repository.ItinerarioRepository;
import EF.Repository.pasajeroRepositorio;
import EF.UnitOfWork;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import UseCases.Consumers.VentaCreadoConsumer;
import UseCases.Consumers.VueloCreadoConsumer;
import factories.itinerario.IitinerarioFactory;
import Fourteam.config.Config;
import Fourteam.extensions.IServiceCollection;

public class ExtensionsInfrastructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(IcheckInRepository.class, CheckInRepository.class);
    IServiceCollection.AddScoped(IitinerarioRepository.class, ItinerarioRepository.class);
    IServiceCollection.AddScoped(IpasajeroRepository.class, pasajeroRepositorio.class);
    Extensions.AddApplication();
    AddRabbitMq();
  }

  private static void AddRabbitMq() {
    IServiceCollection.AddMassTransit(config -> {
      config.AddConsumer(VueloCreadoConsumer.class);
      config.AddConsumer(VentaCreadoConsumer.class);

      config.UsingRabbitMq((context, cfg) -> {
        cfg.Host = Config.getProperty("rabit.host");
        cfg.User = Config.getProperty("rabit.user");
        cfg.Password = Config.getProperty("rabit.pass");
      });
    });
  }
}
