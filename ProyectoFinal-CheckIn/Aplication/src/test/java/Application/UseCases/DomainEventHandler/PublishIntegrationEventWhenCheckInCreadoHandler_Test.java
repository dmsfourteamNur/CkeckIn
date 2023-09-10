package Application.UseCases.DomainEventHandler;

import static org.mockito.Mockito.*;

import java.util.UUID;

import Events.CheckInCreado;
import Fourteam.massTransit.IPublishEndpoint;
import UseCases.DomainEventHandler.PublishIntegrationEventWhenCheckInCreadoHandler;
import core.ConfirmedDomainEvent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PublishIntegrationEventWhenCheckInCreadoHandler_Test {

  private IPublishEndpoint publishEndpoint;
  private PublishIntegrationEventWhenCheckInCreadoHandler handler;

  @Before
  public void setUp() {
    publishEndpoint = Mockito.mock(IPublishEndpoint.class);
    handler = new PublishIntegrationEventWhenCheckInCreadoHandler(publishEndpoint);
  }

  @Test
  public void handle_CheckInCreadoEvent_PublishesIntegrationEvent() throws Exception {
    UUID KeyCheckIn = UUID.randomUUID();
    String CodigoSeguridad = "dsfds";
    CheckInCreado checkInCreadoEvent = new CheckInCreado(KeyCheckIn, CodigoSeguridad);
    ConfirmedDomainEvent<CheckInCreado> domainEvent = new ConfirmedDomainEvent<>(checkInCreadoEvent);
    handler.handle(domainEvent);
  }
}
