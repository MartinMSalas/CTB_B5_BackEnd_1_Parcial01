package main.dao;

import java.util.List;

public interface IDao<E> {
  List<E> findAll();

  E findByRegistration(Integer id);

  //Insert
  E create(E e);
}
