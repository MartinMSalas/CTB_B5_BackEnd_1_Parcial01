package main.model;

public class Odontologo {

  // Se toma matricula como int, depende del tipo podria llegar a ser String
  private int numeroMatricula;
  private String nombre;
  private String apellido;

  public Odontologo() {
  }

  public Odontologo(int numeroMatricula, String nombre, String apellido) {
    this.numeroMatricula = numeroMatricula;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public int getNumeroMatricula() {
    return numeroMatricula;
  }

  public void setNumeroMatricula(int numeroMatricula) {
    this.numeroMatricula = numeroMatricula;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  @Override
  public String toString() {
    return "Odontologo {" +
            "numeroMatricula=" + numeroMatricula +
            ", nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            '}';
  }
}