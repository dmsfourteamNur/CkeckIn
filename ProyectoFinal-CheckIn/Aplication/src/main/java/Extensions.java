import Fourteam.extensions.IServiceCollection;
import Fourteam.mediator.IMediator;
import UseCases.Command.CheckIn.Create.CrearCheckInHandler;
import UseCases.Command.CheckIn.Delete.DeleteCheckInHandler;
import UseCases.Command.CheckIn.Edit.EditCheckInHandler;
import UseCases.DomainEventHandler.PublishIntegrationEventWhenCheckInCreadoHandler;
import UseCases.Queries.GetAll.GetCheckInAllHandler;
import UseCases.Queries.GetAllVenta.GetpasajeroAllHandler;
import UseCases.Queries.GetAllVuelo.GetAllVueloHandler;
import UseCases.Queries.GetById.GetCheckInByIdHandler;
import UseCases.Queries.pasajero.GetById.GetPasajeroByIdHandler;
import UseCases.Queries.pasajero.GetByIdVuelo.GetVueloByIdHandler;
import factories.CheckInFactory;
import factories.ICheckInFactory;
import factories.itinerario.IitinerarioFactory;
import factories.itinerario.ItinerarioFactory;
import factories.pasajero.IPasajeroFactory;
import factories.pasajero.PasajeroFactory;

class Extensions {

  public static void AddApplication() {
    IMediator.registerHandler(GetCheckInByIdHandler.class);
    IMediator.registerHandler(EditCheckInHandler.class);
    IMediator.registerHandler(DeleteCheckInHandler.class);
    IMediator.registerHandler(CrearCheckInHandler.class);
    IMediator.registerHandler(GetCheckInAllHandler.class);
    IMediator.registerHandler(GetPasajeroByIdHandler.class);
    IMediator.registerHandler(GetVueloByIdHandler.class);
    IMediator.registerHandler(GetAllVueloHandler.class);
    IMediator.registerHandler(GetpasajeroAllHandler.class);
    IMediator.registerHandler(PublishIntegrationEventWhenCheckInCreadoHandler.class);
    IServiceCollection.AddTransient(ICheckInFactory.class, CheckInFactory.class);
    IServiceCollection.AddTransient(IitinerarioFactory.class, ItinerarioFactory.class);
    IServiceCollection.AddTransient(IPasajeroFactory.class, PasajeroFactory.class);
    Domain.addDomain();
  }
}
