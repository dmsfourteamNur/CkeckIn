package Application.UseCases.Consumert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Dto.Asiento;
import Modal.Itinerario;
import Repositories.IUnitOfWork;
import Repositories.IitinerarioRepository;
import UseCases.Consumers.VueloCreadoConsumer;
import factories.itinerario.IitinerarioFactory;

public class VueloCreadoConsumerTest {

  IitinerarioRepository iitinerarioRepository = Mockito.mock(IitinerarioRepository.class);
  IitinerarioFactory iitinerarioFactory = Mockito.mock(IitinerarioFactory.class);
  IUnitOfWork unitOfWork = Mockito.mock(IUnitOfWork.class);
  VueloCreadoConsumer vueloCreadoConsumer;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    vueloCreadoConsumer = new VueloCreadoConsumer(iitinerarioRepository, iitinerarioFactory, unitOfWork);
  }

  @Test(expected = Exception.class)
  public void consume_ValidVueloCreado_CreatesItinerario() throws Exception {

    IntegrationEvents.VueloCreado vueloCreado = new IntegrationEvents.VueloCreado();
    vueloCreado.setKey(UUID.randomUUID());
    vueloCreado.setOrigen("origen");
    vueloCreado.setDestino("destino");
    vueloCreado.setFechaArribe(new Date());
    vueloCreado.setFechaSalida(new Date());

    Asiento asiento = new Asiento();
    asiento.setKey(UUID.randomUUID());
    asiento.setNumeroAsiento(0);
    asiento.setDisponibilidad(1);

    Itinerario itinerario = new Itinerario();

    when(iitinerarioFactory.Create(any(), any(), any(), any(), any())).thenReturn(itinerario);

    vueloCreadoConsumer.Consume(vueloCreado);

    verify(iitinerarioFactory, Mockito.times(1)).Create(any(), any(), any(), any(), any());
    verify(iitinerarioRepository, Mockito.times(1)).Create(any());
    verify(unitOfWork, Mockito.times(1)).commit();
  }

  @Test(expected = Exception.class)
  public void consume_InvalidVueloCreado_DoesNotCreateItinerario() throws Exception {

    IntegrationEvents.VueloCreado vueloCreado = new IntegrationEvents.VueloCreado();
    vueloCreado.setKey(UUID.randomUUID());
    vueloCreado.setOrigen("origen");
    vueloCreado.setDestino("destino");
    vueloCreado.setFechaArribe(new Date());
    vueloCreado.setFechaSalida(new Date());

    Asiento asiento = new Asiento();
    asiento.setKey(UUID.randomUUID());
    asiento.setNumeroAsiento(0);
    asiento.setDisponibilidad(1);

    Itinerario itinerario = new Itinerario();

    when(iitinerarioFactory.Create(any(), any(), any(), any(), any())).thenReturn(itinerario);

    vueloCreadoConsumer.Consume(vueloCreado);

    verify(iitinerarioFactory, Mockito.times(1)).Create(any(), any(), any(), any(), any());
    verify(iitinerarioRepository, Mockito.times(1)).Create(any());
    verify(unitOfWork, Mockito.times(1)).commit();
  }

}
