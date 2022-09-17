package UseCases.Consumers;

import Modal.Pasajero;
import Repositories.IUnitOfWork;
import Repositories.IpasajeroRepository;
import Fourteam.massTransit.IConsumer;

public class VentaCreadoConsumer extends IConsumer<IntegrationEvents.VentaCreado> {

  public static String QueueName = "checkin-creado-checkin";

  private IpasajeroRepository ipasajeroRepository;
  private IUnitOfWork _unitOfWork;

  public VentaCreadoConsumer(IpasajeroRepository ipasajeroRepository, IUnitOfWork _unitOfWork) {
    this.ipasajeroRepository = ipasajeroRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public void Consume(IntegrationEvents.VentaCreado object) {
    // Pasajero pasajero = new Pasajero(
    //     object.getKey(),
    //     object.getKeyVuelo(),
    //     object.getNombre(),
    //     object.getApellido(),
    //     object.getDni());
    // ipasajeroRepository.Create(pasajero);
    // _unitOfWork.commit();
  }
}
