package service;

import java.util.Set;

/*
  IEmpService.java
  IEmpService class
  Author: Robyn Dominique Stevens (222201789)
  Date: 19 June 2026
*/
public interface IEmpService <E, ID>{
    E create(E entity);
    E read(ID id);
    E update(E entity);
    boolean delete(ID id);
    Set<E> getAll();
}