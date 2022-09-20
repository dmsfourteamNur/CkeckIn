package UseCases.Consumers;

import Modal.Pasajero;
import Repositories.IUnitOfWork;
import Repositories.IpasajeroRepository;
import factories.pasajero.IPasajeroFactory;
import factories.pasajero.PasajeroFactory;

import java.util.UUID;

import Fourteam.massTransit.IConsumer;

public class VentaCreadoConsumer extends IConsumer<IntegrationEvents.VentaCreado> {

  public static String QueueName = "checkin-creado-checkin";

  private IpasajeroRepository ipasajeroRepository;
  private IPasajeroFactory iPasajeroFactory;
  private IUnitOfWork _unitOfWork;

  public VentaCreadoConsumer(IpasajeroRepository ipasajeroRepository, IPasajeroFactory iPasajeroFactory,
      IUnitOfWork _unitOfWork) {
    this.ipasajeroRepository = ipasajeroRepository;
    this.iPasajeroFactory = iPasajeroFactory;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public void Consume(IntegrationEvents.VentaCreado object) {
    Pasajero pasajero = iPasajeroFactory.Create(object.getKeyVuelo(), object.getNombre(),
        object.getApellido(), object.getDni());
    try {
      ipasajeroRepository.Create(pasajero);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
