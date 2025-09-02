package com.simulation.services;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.services.implementations.category.PachydermServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.animal.services.interfaces.category.PachydermService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import com.simulation.mocks.MockAnimalFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PachydermServiceTest {
    private AnimalService pachydermService;
    private CrudService<Animal, Long> crudService;

    @BeforeEach
    void setUp() {
        crudService = new CrudServiceImpl<>();
        pachydermService = new PachydermServiceImpl(crudService);
        MockAnimalFactory.getMockPacyderm().forEach(pachydermService::create);
    }

    @Test
    void testReadAllPachyderm() {
        List<Animal> all = pachydermService.readAll();
        assertEquals(5, all.size());
    }

    @Test
    void testGetHeaviestPachyderm() {
        Optional<Pachyderm> pachyderm = ((PachydermService) pachydermService).getHeaviestPachyderm();
        assertEquals(3.2, pachyderm.get().getHeight());
    }

    @Test
    void testGetTallestPachyderm() {
        Optional<Pachyderm> pachyderm = ((PachydermService) pachydermService).getTallestPachyderm();
        assertEquals(5000, pachyderm.get().getWeight());
    }
}
