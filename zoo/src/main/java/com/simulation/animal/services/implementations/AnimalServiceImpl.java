package com.simulation.animal.services.implementations;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.generics.interfaces.CrudService;

@Service
public class AnimalServiceImpl implements AnimalService{

    private final CrudService<Animal, Long> crudService;

    public AnimalServiceImpl(CrudService<Animal, Long> crudService) {
        this.crudService = crudService;
    }

    @Override
    public Animal create(Animal entity) {
        return crudService.create(entity);
    }

    @Override
    public Optional<Animal> read(Long id) {
        return crudService.read(id);
    }

    @Override
    public List<Animal> readAll() {
        return crudService.readAll();
    }

    @Override
    public Animal update(Animal entity) {
        return crudService.update(entity);
    }
    public boolean delete(Long id) {
        return crudService.delete(id);
    }

    @Override
    public List<Animal> selectByCategory(String category) {
        return crudService.readAll().stream()
                .filter(a -> a.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> selectBySpecies(String species) {
        return crudService.readAll().stream()
                .filter(a -> a.getSpecies().equalsIgnoreCase(species))
                .collect(Collectors.toList());
    }
}
