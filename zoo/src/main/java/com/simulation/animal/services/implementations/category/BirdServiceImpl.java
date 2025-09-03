package com.simulation.animal.services.implementations.category;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Bird;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.interfaces.category.BirdService;
import com.simulation.generics.interfaces.CrudService;

import java.util.Comparator;
import java.util.Optional;
//TODO: extends `ParentClassServiceImpl` and implements `ClassService`
// - Inherits common behavior from a base service class (ParentClassServiceImpl).
// - Implements the specific interface (ClassService) to provide concrete operations.
// Example:
// public class PachydermServiceImpl extends BaseServiceImpl<Pachyderm> implements PachydermService { ... }
public class BirdServiceImpl extends AnimalServiceImpl implements BirdService {
    public BirdServiceImpl(CrudService<Animal, Long> crudService) {
        super(crudService);
    }
//TODO: inject in constructor `CrudService<ParentClass, T> objectName`
// - Uses constructor injection to provide required CRUD dependencies for the service.
// - Promotes loose coupling and easier testing.
// Example:
// public PachydermServiceImpl(CrudService<Pachyderm, Long> pachydermCrudService) {
//     this.pachydermCrudService = pachydermCrudService;
// }
    @Override
    public Optional<Bird> getLongestWingSpan() {
        return readAll().stream()
                .filter(Bird.class::isInstance)
                .map(Bird.class::cast)
                .max(Comparator.comparingDouble(Bird::getWingspan));
    }
//TODO: override operation that is defined in interface
// - Provides the actual implementation of the method declared in the interface.
// - Ensures the service fulfills the contract expected by the controller or other consumers.
// Example:
// @Override
// public Optional<Pachyderm> getHeaviestPachyderm() {
//     return pachydermCrudService.findAll().stream()
//         .max(Comparator.comparing(Pachyderm::getWeight));
// }
    @Override
    public Optional<Bird> getLongestBeak() {
        return readAll().stream()
                .filter(Bird.class::isInstance)
                .map(Bird.class::cast)
                .max(Comparator.comparingDouble(Bird::getBeaklength));
    }
}