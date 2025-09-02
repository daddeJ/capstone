package com.simulation.services;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.entities.species.Rhino;
import com.simulation.animal.services.implementations.species.RhinoServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.animal.services.interfaces.category.PachydermService;
import com.simulation.animal.services.interfaces.species.RhinoService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import com.simulation.mocks.MockAnimalFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RhinoServiceTest {
    private AnimalService rhinoService;
    private CrudService<Animal, Long> crudService;

    @BeforeEach
    void setUp() {
        this.crudService = new CrudServiceImpl<>();
        this.rhinoService = new RhinoServiceImpl(crudService);
        MockAnimalFactory.getMockRhino().forEach(rhinoService::create);
    }

    @Test
    void testReadAllRhino() {
        List<Animal> all = rhinoService.readAll();
        assertEquals(5, all.size());
    }

    @Test
    void testGetLongestHornLength() {
        Optional<Rhino> pachyderm = ((RhinoService) rhinoService).getLongestHornLength();
        assertEquals(3.2, pachyderm.get().getHornlength());
    }
}
