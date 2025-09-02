package com.simulation.animal.services.implementations.species;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.species.Rhino;
import com.simulation.animal.services.implementations.category.PachydermServiceImpl;
import com.simulation.animal.services.interfaces.species.RhinoService;
import com.simulation.generics.interfaces.CrudService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class RhinoServiceImpl extends PachydermServiceImpl implements RhinoService {
    // TODO: extends `ParentClassServiceImpl` and implements `ClassService`

    // TODO: inject CrudService<ParentClass, T> objectName

    // TODO: override operation that is define in interface
    public RhinoServiceImpl(CrudService<Animal, Long> crudService) {
        super(crudService);
    }

    @Override
    public Optional<Rhino> getLongestHornLength() {
        return readAll().stream()
                .filter(Rhino.class::isInstance)
                .map(Rhino.class::cast)
                .max(Comparator.comparingDouble(Rhino::getHornlength));
    }
}