package Model;

import Modal.Equipaje;
import org.junit.Assert;
import org.junit.Test;

public class Equipaje_Test {

  @Test
  public void Correctly() {
    Double PesoEquipaje = 23.3;
    String NumeroEtiqueta = "sdfd33f3";
    String Descripcion = "sdsfsfse";

    Equipaje objBaggage = new Equipaje(PesoEquipaje, NumeroEtiqueta, Descripcion);

    Equipaje baggage = new Equipaje();

    baggage.setPesoEquipaje(objBaggage.getPesoEquipaje());
    baggage.setNumeroEtiqueta(objBaggage.getNumeroEtiquta());
    baggage.setDescripcion(objBaggage.getDescripcion());

    Assert.assertEquals(PesoEquipaje, baggage.getPesoEquipaje());
    Assert.assertEquals(NumeroEtiqueta, baggage.getNumeroEtiquta());
    Assert.assertEquals(Descripcion, baggage.getDescripcion());
  }
}
