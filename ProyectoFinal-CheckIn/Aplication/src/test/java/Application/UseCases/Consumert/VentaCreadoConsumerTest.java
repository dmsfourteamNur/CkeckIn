package Application.UseCases.Consumert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Modal.Pasajero;
import Repositories.IUnitOfWork;
import Repositories.IpasajeroRepository;
import UseCases.Consumers.VentaCreadoConsumer;
import factories.pasajero.IPasajeroFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

public class VentaCreadoConsumerTest {

  IpasajeroRepository ipasajeroRepository = Mockito.mock(IpasajeroRepository.class);
  IPasajeroFactory iPasajeroFactory = Mockito.mock(IPasajeroFactory.class);
  IUnitOfWork unitOfWork = Mockito.mock(IUnitOfWork.class);
  VentaCreadoConsumer ventaCreadoConsumer;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    ventaCreadoConsumer = new VentaCreadoConsumer(ipasajeroRepository, iPasajeroFactory, unitOfWork);
  }

  @Test(expected = Exception.class)
  public void consume_ValidVentaCreado_CreatesPasajero() throws Exception {

    IntegrationEvents.VentaCreado ventaCreado = new IntegrationEvents.VentaCreado();
    ventaCreado.setKeyVuelo(UUID.randomUUID());
    ventaCreado.setNombre("nombre");
    ventaCreado.setApellido("apellido");
    ventaCreado.setDni("12345678");

    Pasajero pasajero = new Pasajero();

    when(iPasajeroFactory.Create(any(), any(), any(), any(), any())).thenReturn(pasajero);

    ventaCreadoConsumer.Consume(ventaCreado);

    verify(iPasajeroFactory, Mockito.times(1)).Create(any(), any(), any(), any(), any());
    verify(ipasajeroRepository, Mockito.times(1)).Create(any());
    verify(unitOfWork, Mockito.times(1)).commit();
  }

  @Test(expected = Exception.class)
  public void consume_InvalidVentaCreado_DoesNotCreatePasajero() throws Exception {

    IntegrationEvents.VentaCreado ventaCreado = new IntegrationEvents.VentaCreado();
    ventaCreado.setKeyVuelo(UUID.randomUUID());
    ventaCreado.setNombre("nombre");
    ventaCreado.setApellido("apellido");
    ventaCreado.setDni("12345678");

    Pasajero pasajero = new Pasajero();
    pasajero.key = UUID.randomUUID();
    pasajero.setKeyVenta(UUID.randomUUID());
    pasajero.setNombre("nombre");
    pasajero.setApellido("apellido");
    pasajero.setDni(12345678);

    when(iPasajeroFactory.Create(pasajero.key, pasajero.getKeyVenta(), pasajero.getNombre(),
        pasajero.getApellido(), pasajero.getDni())).thenReturn(pasajero);

    verify(iPasajeroFactory, Mockito.times(1)).Create(any(), any(), any(), any(), any());
    verify(ipasajeroRepository, Mockito.times(1)).Create(any());
    verify(unitOfWork, Mockito.times(0)).commit();
  }
}
