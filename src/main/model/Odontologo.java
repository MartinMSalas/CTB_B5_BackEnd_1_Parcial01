package main.model;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Odontologo that = (Odontologo) o;

    if (numeroMatricula != that.numeroMatricula) return false;
    if (!Objects.equals(nombre, that.nombre)) return false;
    return Objects.equals(apellido, that.apellido);
  }

  @Override
  public int hashCode() {
    int result = numeroMatricula;
    result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
    result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
    return result;
  }
}
