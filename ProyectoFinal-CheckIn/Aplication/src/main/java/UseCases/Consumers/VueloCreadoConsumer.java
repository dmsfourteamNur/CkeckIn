package UseCases.Consumers;

import Modal.Itinerario;
import Repositories.IUnitOfWork;
import Repositories.IitinerarioRepository;
import factories.itinerario.IitinerarioFactory;
import fourteam.massTransit.IConsumer;

public class VueloCreadoConsumer extends IConsumer<IntegrationEvents.VueloCreado> {

  public static String QueueName = "checkin-creado-checkin";

  private IitinerarioRepository iitinerarioRepository;
  private IitinerarioFactory iitinerarioFactory;
  private IUnitOfWork _unitOfWork;

  public VueloCreadoConsumer(
    IitinerarioRepository iitinerarioRepository,
    IitinerarioFactory iitinerarioFactory,
    IUnitOfWork _unitOfWork
  ) {
    this.iitinerarioRepository = iitinerarioRepository;
    this.iitinerarioFactory = iitinerarioFactory;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public void Consume(IntegrationEvents.VueloCreado objeto) throws Exception {
    Itinerario itinerario = iitinerarioFactory.Create(
      objeto.getKey(),
      objeto.getCiudadOrigen(),
      objeto.getCiudadDestino(),
      objeto.getFechaArribe(),
      objeto.getFechaSalida()
    );

    for (var item : objeto.getAsiento()) {
      itinerario.AgregarAsientos(item.getKey(), item.getNumeroAsiento(), item.getDisponibilidad());
    }

    iitinerarioRepository.Create(itinerario);
    _unitOfWork.commit();

    System.out.println("Se Agrego el itinerario y los asientos");
  }
}
