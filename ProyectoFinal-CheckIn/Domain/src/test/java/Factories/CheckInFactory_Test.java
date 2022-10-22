package Factories;

import static org.mockito.Mockito.*;

import Fourteam.http.Exception.HttpException;
import Modal.CheckIn;
import factories.CheckInFactory;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

public class CheckInFactory_Test {

  @Before
  public void setup() {}

  @Test
  public void HandleCheckFactory_Ok() throws HttpException {
    String CodigoSeguridad = "dsfds";
    int NumeroAsiento = 33;
    Boolean EstadoPaciente = true;
    UUID keyVenta = UUID.randomUUID();
    UUID keyVuelo = UUID.randomUUID();
    UUID keyasiento = UUID.randomUUID();

    CheckIn objCheckIn = new CheckIn(
      CodigoSeguridad,
      EstadoPaciente,
      CodigoSeguridad,
      NumeroAsiento,
      keyVuelo,
      keyasiento,
      keyVenta
    );

    CheckInFactory checkInFactory = new CheckInFactory();
    CheckIn checkIn = checkInFactory.Create(
      anyString(),
      anyBoolean(),
      anyString(),
      anyInt(),
      any(),
      any(),
      any()
    );
  }
}
