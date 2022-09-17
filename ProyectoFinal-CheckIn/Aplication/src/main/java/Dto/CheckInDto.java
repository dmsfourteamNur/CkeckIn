package Dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CheckInDto {

  public UUID Key;
  public String CodigoSeguridad;
  public Date HoraCheckIn;
  public Boolean EstadoPaciente;
  public String Descripcion;
  public int NumeroAsiento;
  public UUID KeyVuelo;
  public UUID KeyPasajero;
  public List<EquipajeDto> EquipajeDto;

  public CheckInDto() {}

  public UUID getKey() {
    return this.Key;
  }

  public void setKey(UUID Key) {
    this.Key = Key;
  }

  public String getCodigoSeguridad() {
    return this.CodigoSeguridad;
  }

  public void setCodigoSeguridad(String CodigoSeguridad) {
    this.CodigoSeguridad = CodigoSeguridad;
  }

  public Date getHoraCheckIn() {
    return this.HoraCheckIn;
  }

  public void setHoraCheckIn(Date HoraCheckIn) {
    this.HoraCheckIn = HoraCheckIn;
  }

  public Boolean isEstadoPaciente() {
    return this.EstadoPaciente;
  }

  public Boolean getEstadoPaciente() {
    return this.EstadoPaciente;
  }

  public void setEstadoPaciente(Boolean EstadoPaciente) {
    this.EstadoPaciente = EstadoPaciente;
  }

  public String getDescripcion() {
    return this.Descripcion;
  }

  public void setDescripcion(String Descripcion) {
    this.Descripcion = Descripcion;
  }

  public int getNumeroAsiento() {
    return this.NumeroAsiento;
  }

  public void setNumeroAsiento(int NumeroAsiento) {
    this.NumeroAsiento = NumeroAsiento;
  }

  public UUID getKeyVuelo() {
    return this.KeyVuelo;
  }

  public void setKeyVuelo(UUID KeyVuelo) {
    this.KeyVuelo = KeyVuelo;
  }

  public UUID getKeyPasajero() {
    return this.KeyPasajero;
  }

  public void setKeyPasajero(UUID KeyPasajero) {
    this.KeyPasajero = KeyPasajero;
  }

  public List<EquipajeDto> getEquipajeDto() {
    return this.EquipajeDto;
  }

  public void setEquipajeDto(List<EquipajeDto> EquipajeDto) {
    this.EquipajeDto = EquipajeDto;
  }
}
