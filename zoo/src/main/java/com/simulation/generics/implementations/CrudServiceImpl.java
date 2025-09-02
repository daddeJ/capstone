package com.simulation.generics.implementations;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.simulation.generics.interfaces.CrudService;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl<T, ID> implements CrudService<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();
    /* TODO:
        update constructor and inject repository to use DB as storage
        private final GenericRepository<T, ID> repository;
        public CrudService(GenericRepository<T, ID> repository) {
           this.repository = repository;
        }
    */
    @Override
    public T create(T entity) {
        try {
            ID id = (ID) entity.getClass().getMethod("getId").invoke(entity);
            storage.put(id, entity);
            return entity;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to get ID from entity", e);
        }
    }

    @Override
    public Optional<T> read(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> readAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public T update(T entity) {
        try {
            ID id = (ID) entity.getClass().getMethod("getId").invoke(entity);
            if (!storage.containsKey(id)) throw new NoSuchElementException("Entity not found");
            storage.put(id, entity);
            return entity;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to update entity", e);
        }
    }

    @Override
    public boolean delete(ID id) {
        return storage.remove(id) != null;
    }
}
