package UseCases.Consumers;

import Fourteam.massTransit.IConsumer;
import Modal.Itinerario;
import Repositories.IUnitOfWork;
import Repositories.IitinerarioRepository;
import factories.itinerario.IitinerarioFactory;

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
  public void Consume(IntegrationEvents.VueloCreado objeto) {
    Itinerario itinerario = iitinerarioFactory.Create(
      objeto.getKey(),
      objeto.getOrigen(),
      objeto.getDestino(),
      objeto.getFechaArribe(),
      objeto.getFechaSalida()
    );

    for (var item : objeto.listaAsientos) {
      itinerario.AgregarAsientos(item.getKey(), item.getNumero(), item.getDisponibilidad());
    }

    try {
      iitinerarioRepository.Create(itinerario);
      _unitOfWork.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
