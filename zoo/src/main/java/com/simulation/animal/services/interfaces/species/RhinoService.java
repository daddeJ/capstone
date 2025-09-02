package com.simulation.animal.services.interfaces.species;

import com.simulation.animal.entities.species.Rhino;

import java.util.Optional;

public interface RhinoService {
    Optional<Rhino> getLongestHornLength();
}