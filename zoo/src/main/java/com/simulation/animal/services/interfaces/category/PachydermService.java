package com.simulation.animal.services.interfaces.category;

import com.simulation.animal.entities.category.Pachyderm;

import java.util.Optional;

public interface PachydermService {
    Optional<Pachyderm> getHeaviestPachyderm();
    Optional<Pachyderm> getTallestPachyderm();
}
