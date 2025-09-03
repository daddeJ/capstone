package com.simulation.animal.services.interfaces.category;

import com.simulation.animal.entities.category.Feline;

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
public interface FelineService {
    Optional<Feline> getLongestClawLength();
    Optional<Feline> getLongestTailLength();
}