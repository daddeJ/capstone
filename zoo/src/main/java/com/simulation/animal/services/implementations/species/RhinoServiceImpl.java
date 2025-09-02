package com.simulation.animal.services.implementations.species;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.species.Rhino;
import com.simulation.animal.services.implementations.category.PachydermServiceImpl;
import com.simulation.animal.services.interfaces.species.RhinoService;
import com.simulation.generics.interfaces.CrudService;

import java.util.Comparator;
import java.util.Optional;

public class RhinoServiceImpl extends PachydermServiceImpl implements RhinoService {
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