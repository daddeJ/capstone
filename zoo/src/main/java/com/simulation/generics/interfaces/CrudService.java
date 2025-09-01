package com.simulation.generics.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    T create(T entity);
    Optional<T> read(ID id);
    List<T> readAll();
    T update(T entity);
    boolean delete(ID id);
}