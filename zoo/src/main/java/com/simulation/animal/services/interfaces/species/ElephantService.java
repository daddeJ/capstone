package com.simulation.animal.services.interfaces.species;

import com.simulation.animal.entities.species.Elephant;

import java.util.Optional;

/*
TODO: define operation in interface
 - Declares a contract for a specific operation that any implementing class must provide.
 - Promotes abstraction, loose coupling, and allows the controller to call the operation without knowing the implementation details.
 Example:
    public interface PachydermService {
        Optional<Pachyderm> getHeaviestPachyderm();
    }
*/
public interface ElephantService {
    Optional<Elephant> getLongestTrunkLength();
}