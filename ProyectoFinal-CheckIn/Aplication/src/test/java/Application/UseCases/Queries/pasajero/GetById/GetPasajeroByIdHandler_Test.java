package Application.UseCases.Queries.pasajero.GetById;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import Modal.Pasajero;
import Repositories.IpasajeroRepository;
import UseCases.Queries.pasajero.GetById.GetPasajeroByIdHandler;
import UseCases.Queries.pasajero.GetById.GetPasajeroByIdQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.PasajeroDto;

public class GetPasajeroByIdHandler_Test {

  private IpasajeroRepository ipasajeroRepository;
  private GetPasajeroByIdHandler handler;

  @Before
  public void setUp() {
    ipasajeroRepository = Mockito.mock(IpasajeroRepository.class);
    handler = new GetPasajeroByIdHandler(ipasajeroRepository);
  }

  @Test
  public void handle_PasajeroExists_ReturnsPasajeroDto() throws Exception {
    int dni = 12345678;
    Pasajero pasajero = new Pasajero();
    pasajero.setKeyVenta(UUID.randomUUID());
    pasajero.setNombre("Nombre");
    pasajero.setApellido("Apellido");
    pasajero.setDni(dni);

    when(ipasajeroRepository.FindByKeyPasajero(anyInt())).thenReturn(pasajero);
    GetPasajeroByIdQuery query = new GetPasajeroByIdQuery(dni);
    PasajeroDto pasajeroDto = handler.handle(query);
    assertNotNull(pasajeroDto);
    assertEquals(pasajero.getKey(), pasajeroDto.getKeyVenta());
    assertEquals(pasajero.getKeyVenta(), pasajeroDto.getKeyVuelo());
    assertEquals(pasajero.getNombre(), pasajeroDto.getNombre());
    assertEquals(pasajero.getApellido(), pasajeroDto.getApellido());
    assertEquals(pasajero.getDni(), pasajeroDto.getDni());
  }

  @Test
  public void handle_PasajeroNotExists_ReturnsNull() throws Exception {
    int dni = 87654321;
    when(ipasajeroRepository.FindByKeyPasajero(dni)).thenReturn(null);
    GetPasajeroByIdQuery query = new GetPasajeroByIdQuery(dni);
    PasajeroDto pasajeroDto = handler.handle(query);
    assertNull(pasajeroDto);
  }
}
