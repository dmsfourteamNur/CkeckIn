package Application.UseCases.Queries.pasajero.GetByIdVuelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Modal.Itinerario;
import Modal.Pasajero;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.UUID;

import Dto.VueloPersonaDto;
import Repositories.IitinerarioRepository;
import Repositories.IpasajeroRepository;
import UseCases.Queries.pasajero.GetByIdVuelo.GetVueloByIdHandler;
import UseCases.Queries.pasajero.GetByIdVuelo.GetVueloPasajeroQuery;

public class GetVueloByIdHandler_Test {

  private IpasajeroRepository ipasajeroRepository;
  private IitinerarioRepository iitinerarioRepository;
  private GetVueloByIdHandler handler;

  @Before
  public void setUp() {
    ipasajeroRepository = Mockito.mock(IpasajeroRepository.class);
    iitinerarioRepository = Mockito.mock(IitinerarioRepository.class);
    handler = new GetVueloByIdHandler(ipasajeroRepository, iitinerarioRepository);
  }

  @Test
  public void handle_ValidPasajeroAndItinerario_ReturnsVueloPersonaDto() throws Exception {
    UUID keyVenta = UUID.randomUUID();
    UUID keyVuelo = UUID.randomUUID();
    int dni = 12345678;
    Pasajero pasajero = new Pasajero(keyVuelo, keyVenta, "nombre", "apellido", dni);
    Itinerario itinerario = new Itinerario(keyVuelo, "origen", "destino", null, null);

    when(ipasajeroRepository.FindByKeyPasajero(anyInt())).thenReturn(pasajero);
    when(iitinerarioRepository.FindByKey(any())).thenReturn(itinerario);

    GetVueloPasajeroQuery query = new GetVueloPasajeroQuery(dni);

    VueloPersonaDto result = handler.handle(query);

    assertEquals(keyVenta, result.getKeyVenta());
    assertEquals(keyVuelo, result.getKeyVuelo());
    assertEquals("nombre", result.getNombre());
    assertEquals("apellido", result.getApellido());
    assertEquals(dni, result.getDni());
    assertEquals("origen", result.getOrigen());
    assertEquals("destino", result.getDestino());
  }

  @Test
    public void handle_PasajeroNotFound_ThrowsHttpException() throws Exception {
        when(ipasajeroRepository.FindByKeyPasajero(anyInt())).thenReturn(null);
        GetVueloPasajeroQuery query = new GetVueloPasajeroQuery(12345678);
        HttpException exception = assertThrows(HttpException.class, () -> handler.handle(query));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getCode());
        assertEquals("NO EXISTE EL PASAJERO", exception.getMessage());
    }

  @Test
  public void handle_ItinerarioNotFound_ThrowsHttpException() throws Exception {
    Pasajero pasajero = new Pasajero(UUID.randomUUID(), UUID.randomUUID(), "nombre", "apellido", 12345678);
    when(ipasajeroRepository.FindByKeyPasajero(anyInt())).thenReturn(pasajero);
    when(iitinerarioRepository.FindByKey(any())).thenReturn(null);
    GetVueloPasajeroQuery query = new GetVueloPasajeroQuery(12345678);
    HttpException exception = assertThrows(HttpException.class, () -> handler.handle(query));
    assertEquals(HttpStatus.BAD_REQUEST, exception.getCode());
    assertEquals("EL PASAJERO NO TIENE ASIGNADO NINGUN VUELO", exception.getMessage());
  }
}
