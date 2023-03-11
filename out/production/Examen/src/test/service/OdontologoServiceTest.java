package test.service;

import main.model.Odontologo;
import main.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OdontologoServiceTest {

  @Test
  public void testOdontologoServiceCrearOdontologo(){
    // Given
    OdontologoService odontologoService = new OdontologoService();
    Odontologo odontologo = new Odontologo(10,"Dientes","DeOro");

    // When
    boolean result = odontologoService.createNewOdontologo(odontologo);
    // Then
    Assertions.assertTrue(result);


  }

  @Test
  public void testOdontologoServiceListAllOdontologo(){
    // Given
    OdontologoService odontologoService = new OdontologoService();

    List<Odontologo> odontologoListExpected = new ArrayList<>();

    // When
    List<Odontologo> odontologoListObtained = odontologoService.listAll();

    for (Odontologo odontologo: odontologoListObtained
         ) {
      System.out.println(odontologo);
    }
    // Then
    //Assertions.assertArrayEquals(odontologoListEsperada,odontologoListObtenida);
  }


}
