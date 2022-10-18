package UseCases.DomainEventHandler;

import Events.CheckInCreado;
import core.ConfirmedDomainEvent;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenCheckInCreadoHandler
    implements NotificationHandler<ConfirmedDomainEvent<CheckInCreado>> {

  private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenCheckInCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(ConfirmedDomainEvent<CheckInCreado> event) {

    CheckInCreado checkInCreado = (CheckInCreado) event.DomainEvent;

    IntegrationEvents.AeronaveCreado evento = new IntegrationEvents.AeronaveCreado();

    evento.setKeyAeronave(checkInCreado.getKey());

    this.publishEndpoint.Publish(event);

  }
}
