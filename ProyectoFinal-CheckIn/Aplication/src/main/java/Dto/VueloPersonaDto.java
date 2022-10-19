package Dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VueloPersonaDto {

  private UUID keyVenta;
  private int dni;
  private UUID keyVuelo;
  private String nombre;
  private String apellido;

  private Date fechaSalida;
  private Date fechaArribe;
  private String origen;
  private String destino;
  private List<Asiento> asientos;

  public UUID getKeyVenta() {
    return this.keyVenta;
  }

  public void setKeyVenta(UUID keyVenta) {
    this.keyVenta = keyVenta;
  }

  public Date getFechaSalida() {
    return this.fechaSalida;
  }

  public void setFechaSalida(Date fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public Date getFechaArribe() {
    return this.fechaArribe;
  }

  public void setFechaArribe(Date fechaArribe) {
    this.fechaArribe = fechaArribe;
  }

  public String getOrigen() {
    return this.origen;
  }

  public void setOrigen(String origen) {
    this.origen = origen;
  }

  public String getDestino() {
    return this.destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public List<Asiento> getAsientos() {
    return this.asientos;
  }

  public void setAsientos(List<Asiento> asientos) {
    this.asientos = asientos;
  }

  public UUID getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

}
