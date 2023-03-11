package main.service;

import main.dao.IDao;
import main.dao.impl.DaoOdontologoH2;
import main.model.Odontologo;

import java.util.List;

public class OdontologoService {

  IDao<Odontologo> daoOdontologoH2 = new DaoOdontologoH2();

  public boolean createNewOdontologo(Odontologo odontologo){
    return daoOdontologoH2.create(odontologo) != null;
  }
  public List<Odontologo> listAll(){
    List<Odontologo> odontologoList = null;

    odontologoList = daoOdontologoH2.findAll();


    return  odontologoList;
    /*


    Paciente paciente = null;


    paciente = pacienteDao.findById(id);
    Domicilio d = domicilioDao.findById(paciente.getDomicilio().getId());

    paciente.setDomicilio(d);

    return paciente;

     */

  }

}
