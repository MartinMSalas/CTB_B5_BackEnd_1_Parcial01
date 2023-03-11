package main.dao.impl;

import main.dao.AbstractDaoH2;
import main.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOdontologoH2 extends AbstractDaoH2<Odontologo> {
  public Logger logger = Logger.getLogger(DaoOdontologoH2.class);
  private final String TABLA = "odontologo";
  @Override
  public List<Odontologo> findAll() {
    List<Odontologo> odontologoList = new ArrayList<>();
    String SQL_QUERY = "SELECT * FROM " + TABLA;

    //[1] Obtener y levantar el controlador
    try {
      Class.forName("org.h2.Driver");
      logger.info("Driver h2 is UP !!!");
    } catch (ClassNotFoundException ex) {
      logger.error(ex.getMessage());
    }
    //[2] Abrir la conexión a la base de datos, y usar esa conexión para crear un objeto tipo PreparedStatement
    try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
      Statement stmt = conn.createStatement()){
      ResultSet rs = stmt.executeQuery(SQL_QUERY);
      if(rs != null)
        logger.info("Query executed");
      Odontologo odontologo;
      while (rs.next()){
        odontologo = new Odontologo();
        odontologo.setNumeroMatricula(rs.getInt("numero_matricula"));
        odontologo.setNombre(rs.getString("nombre"));
        odontologo.setApellido(rs.getString("apellido"));
        odontologoList.add(odontologo);
        logger.info("New odontologo added to the list");
      }
    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }
    return odontologoList;
  }
  @Override
  public Odontologo findByRegistration(Integer id) {
    Odontologo result = null;
    //[1] Obtener y levantar el controlador
    try {
      Class.forName("org.h2.Driver");
      logger.info("Driver h2 is UP !!!");
    } catch (ClassNotFoundException ex) {
      logger.error(ex.getMessage());
    }

    //[2] Abrir la conexión a la base de datos, y usar esa conexión para crear un objeto tipo PreparedStatement
    try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
      PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TABLA + " WHERE numero_matricula = ?")){
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()){
        result = new Odontologo();
        result.setNumeroMatricula(rs.getInt("numero_matricula"));
        result.setNombre(rs.getString("nombre"));
        result.setApellido(rs.getString("apellido"));
        logger.info("New Odontologo retrieved from DB");
      }

    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }
    return result;
  }
  @Override
  public Odontologo create(Odontologo odontologo) {
    String SQL_INSERT = "INSERT INTO " + TABLA + "(numero_matricula, nombre, apellido) VALUES(?, ?, ?)";
    Odontologo result = null;
    //[1] Obtener y levantar el controlador
    try {
      Class.forName("org.h2.Driver");
      logger.info("Driver h2 is UP !!!");
    } catch (ClassNotFoundException ex) {
      logger.error(ex.getMessage());
    }
    //[2] Abrir la conexión a la base de datos, y usar esa conexión para crear un objeto tipo PreparedStatement
    try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
      PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)){
      stmt.setInt(1, odontologo.getNumeroMatricula());
      stmt.setString(2, odontologo.getNombre());
      stmt.setString(3, odontologo.getApellido());
      if(stmt.executeUpdate() == 1){
        logger.info("New Odontologo inserted in table");
        result =  odontologo;
      }
    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }
    return result;
  }
}
