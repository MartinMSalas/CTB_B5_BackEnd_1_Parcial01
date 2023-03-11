package main.dao;

import main.model.Odontologo;

import java.util.List;

public abstract class AbstractDaoH2<Odontologo> implements IDao<Odontologo>{

  protected String url = "jdbc:h2:~/db_clinica_20231;INIT=RUNSCRIPT FROM 'create.sql'";
  protected String username = "sa";
  protected String password = "";
}
