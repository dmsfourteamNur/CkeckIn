package UseCases.Consumers;

import Fourteam.massTransit.IConsumer;
import Modal.Pasajero;
import Repositories.IUnitOfWork;
import Repositories.IpasajeroRepository;
import factories.pasajero.IPasajeroFactory;

public class VentaCreadoConsumer extends IConsumer<IntegrationEvents.VentaCreado> {

  public static String QueueName = "checkin-creado-checkin";

  private IpasajeroRepository ipasajeroRepository;
  private IPasajeroFactory iPasajeroFactory;
  private IUnitOfWork _unitOfWork;

  public VentaCreadoConsumer(
      IpasajeroRepository ipasajeroRepository,
      IPasajeroFactory iPasajeroFactory,
      IUnitOfWork _unitOfWork) {
    this.ipasajeroRepository = ipasajeroRepository;
    this.iPasajeroFactory = iPasajeroFactory;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public void Consume(IntegrationEvents.VentaCreado object) {
    try {
      Pasajero pasajero = iPasajeroFactory.Create(
          object.getKeyVuelo(),
          object.getKey(),
          object.getNombre(),
          object.getApellido(),
          Integer.parseInt(object.getDni()));
      ipasajeroRepository.Create(pasajero);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
