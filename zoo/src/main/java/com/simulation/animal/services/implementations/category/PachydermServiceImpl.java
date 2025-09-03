package com.simulation.animal.services.implementations.category;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.interfaces.category.PachydermService;
import com.simulation.generics.interfaces.CrudService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class PachydermServiceImpl extends AnimalServiceImpl implements PachydermService {
    // TODO: extends `ParentClassServiceImpl` and implements `ClassService`

    // TODO: inject CrudService<ParentClass, T> objectName

    // TODO: override operation that is define in interface
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