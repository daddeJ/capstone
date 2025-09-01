package com.simulation.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import com.simulation.mocks.MockAnimalFactory;

public class AnimalServiceTest {
    private AnimalService animalService;
    private CrudService<Animal, Long> crudService;

    @BeforeEach
    void setUp() {
        crudService = new CrudServiceImpl<>();
        animalService = new AnimalServiceImpl(crudService);
        MockAnimalFactory.getMockAnimals().forEach(animalService::create);
    }

    @Test
    void testCreateAnimal() {
        Animal parrot = new Animal() {{
            setId(6L);
            setAnimalId("A006");
            setName("Parrot");
            setCategory("Bird");
            setSpecies("Parrot");
            setHealthy(true);
        }};

        animalService.create(parrot);
        assertEquals(6, animalService.readAll().size());
    }

    @Test
    void testUpdateAnimal() {
        Animal tmpAnimal = animalService.read(1L).orElseThrow();
        tmpAnimal.setName("Cat");
        tmpAnimal.setSpecies("Cat");

        animalService.update(tmpAnimal);
        Animal updatedAnimal = animalService.read(tmpAnimal.getId()).orElseThrow();

        assertEquals("Cat", updatedAnimal.getName());
        assertEquals("Cat", updatedAnimal.getSpecies());
        assertEquals("Feline", updatedAnimal.getCategory());
    }

    @Test
    void testReadAnimalById() {
        Animal tmpAnimal = animalService.read(2L).orElseThrow();
        assertEquals("Lion", tmpAnimal.getSpecies());
        assertEquals("Feline", tmpAnimal.getCategory());
    }

    @Test
    void testDeleteAnimal() {
        int sizeBefore = animalService.readAll().size();
        
        boolean deleted = animalService.delete(3L);
        assertTrue(deleted);

        int sizeAfter = animalService.readAll().size();
        assertEquals(sizeBefore - 1, sizeAfter);
        
        Optional<Animal> deletedAnimal = animalService.read(3L);
        assertTrue(deletedAnimal.isEmpty());
    }

    @Test
    void testReadAllAnimals() {
        List<Animal> all = animalService.readAll();
        assertEquals(6, all.size());
    }

    @Test
    void testSelectFelines() {
        List<Animal> felines = animalService.readAll().stream()
                .filter(a -> "Feline".equals(a.getCategory()))
                .toList();

        assertEquals(2, felines.size());
    }
}
