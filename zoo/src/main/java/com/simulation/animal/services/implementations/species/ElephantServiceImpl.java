package com.simulation.animal.services.implementations.species;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.species.Elephant;
import com.simulation.animal.services.implementations.category.PachydermServiceImpl;
import com.simulation.animal.services.interfaces.species.ElephantService;
import com.simulation.generics.interfaces.CrudService;

import java.util.Comparator;
import java.util.Optional;

public class ElephantServiceImpl extends PachydermServiceImpl implements ElephantService {
    public ElephantServiceImpl(CrudService<Animal, Long> crudService) {
        super(crudService);
    }

    @Override
    public Optional<Elephant> getLongestTrunkLength() {
        return readAll().stream()
                .filter(Elephant.class::isInstance)
                .map(Elephant.class::cast)
                .max(Comparator.comparingDouble(Elephant::getTrunklength));
    }
//TODO: extends `ParentClassServiceImpl` and implements `ClassService`
// - Inherits common behavior from a base service class (ParentClassServiceImpl).
// - Implements the specific interface (ClassService) to provide concrete operations.
// Example:
// public class PachydermServiceImpl extends BaseServiceImpl<Pachyderm> implements PachydermService { ... }

//TODO: inject in constructor `CrudService<ParentClass, T> objectName`
// - Uses constructor injection to provide required CRUD dependencies for the service.
// - Promotes loose coupling and easier testing.
// Example:
// public PachydermServiceImpl(CrudService<Pachyderm, Long> pachydermCrudService) {
//     this.pachydermCrudService = pachydermCrudService;
// }

//TODO: override operation that is defined in interface
// - Provides the actual implementation of the method declared in the interface.
// - Ensures the service fulfills the contract expected by the controller or other consumers.
// Example:
// @Override
// public Optional<Pachyderm> getHeaviestPachyderm() {
//     return pachydermCrudService.findAll().stream()
//         .max(Comparator.comparing(Pachyderm::getWeight));
// }
}