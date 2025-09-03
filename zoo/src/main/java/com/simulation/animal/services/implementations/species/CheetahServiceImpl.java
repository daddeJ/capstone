package com.simulation.animal.services.implementations.species;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Feline;
import com.simulation.animal.entities.species.Cheetah;
import com.simulation.animal.services.implementations.category.FelineServiceImpl;
import com.simulation.animal.services.interfaces.species.CheetahService;
import com.simulation.generics.interfaces.CrudService;

import java.util.Optional;

public class CheetahServiceImpl extends FelineServiceImpl implements CheetahService {
    public CheetahServiceImpl(CrudService<Animal, Long> crudService) {
        super(crudService);
    }

    @Override
    public Optional<Cheetah> getBySpotPattern(String spotpattern) {
        return readAll().stream()
                .filter(Cheetah.class::isInstance)
                .map(Cheetah.class::cast)
                .filter(a -> a.getSpotpattern().equalsIgnoreCase(spotpattern))
                .findFirst();
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