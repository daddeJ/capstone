package com.simulation.animal.services.implementations.category;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.interfaces.category.PachydermService;
import com.simulation.generics.interfaces.CrudService;

import java.util.Comparator;
import java.util.Optional;

public class PachydermServiceImpl extends AnimalServiceImpl implements PachydermService {
    public PachydermServiceImpl(CrudService<Animal, Long> crudService) {
        super(crudService);
    }

    @Override
    public Optional<Pachyderm> getHeaviestPachyderm() {
        return readAll().stream()
                .filter(Pachyderm.class::isInstance)
                .map(Pachyderm.class::cast)
                .max(Comparator.comparingDouble(Pachyderm::getWeight));
    }

    @Override
    public Optional<Pachyderm> getTallestPachyderm() {
        return readAll().stream()
                .filter(Pachyderm.class::isInstance)
                .map(Pachyderm.class::cast)
                .max(Comparator.comparingDouble(Pachyderm::getHeight));
    }
}