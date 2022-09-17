package UseCases.Consumers;

import Modal.Itinerario;
import Repositories.IUnitOfWork;
import Repositories.IitinerarioRepository;
import factories.itinerario.IitinerarioFactory;
import Fourteam.massTransit.IConsumer;

public class VueloCreadoConsumer extends IConsumer<IntegrationEvents.VueloCreado> {

  public static String QueueName = "checkin-creado-checkin";

  private IitinerarioRepository iitinerarioRepository;
  private IitinerarioFactory iitinerarioFactory;
  private IUnitOfWork _unitOfWork;

  public VueloCreadoConsumer(
      IitinerarioRepository iitinerarioRepository,
      IUnitOfWork _unitOfWork) {
    this.iitinerarioRepository = iitinerarioRepository;
    this.iitinerarioFactory = iitinerarioFactory;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public void Consume(IntegrationEvents.VueloCreado objeto) {
    Itinerario itinerario = iitinerarioFactory.Create(
        objeto.getNroVuelo(),
        objeto.getKeyAeropuertoOrigen(),
        objeto.getKeyAeropuertoDestino(),
        objeto.getFechaArribe(),
        objeto.getFechaSalida());

    // for (var item : objeto.getAsiento()) {
    // itinerario.AgregarAsientos(item.getKey(), item.getNumero(),
    // item.getDisponibilidad());
    // }
    try {
      iitinerarioRepository.Create(itinerario);
      _unitOfWork.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
