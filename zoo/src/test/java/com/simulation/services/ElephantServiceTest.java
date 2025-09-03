package com.simulation.services;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.species.Elephant;
import com.simulation.animal.services.implementations.species.ElephantServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.animal.services.interfaces.species.ElephantService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import com.simulation.mocks.MockAnimalFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElephantServiceTest {
//TODO: define service test class
//    - Create a JUnit test class for testing service layer operations.
//    - Ensures business logic works independently of controllers.
//    Example:
//        public class AnimalServiceTest { ... }
//
    private AnimalService elephantService;
    private CrudService<Animal, Long> crudService;
//TODO: declare service and dependencies
//    - Define service under test and any required dependencies (e.g., CrudService).
//    - Allows initialization and injection before each test.
//    Example:
//        private AnimalService animalService;
//        private CrudService<Animal, Long> crudService;
//
    @BeforeEach
    void setUp() {
        crudService = new CrudServiceImpl<>();
        elephantService = new ElephantServiceImpl(crudService);
        MockAnimalFactory.getMockElephant().forEach(elephantService::create);
    }

    @Test
    void testReadAllElephant() {
        List<Animal> all = elephantService.readAll();
        assertEquals(5, all.size());
    }

    @Test
    void testGetLongestTrunkLength() {
        Optional<Elephant> pachyderm = ((ElephantService) elephantService).getLongestTrunkLength();
        assertEquals(4.0, pachyderm.get().getTrunklength());
    }
//TODO: set up test environment with '@BeforeEach'
//    - Initializes service and dependencies before each test.
//    - Optionally pre-load mock data for consistent testing.
//    Example:
//        @BeforeEach
//        void setUp() {
//            crudService = new CrudServiceImpl<>();
//            animalService = new AnimalServiceImpl(crudService);
//            MockAnimalFactory.getMockAnimals().forEach(animalService::create);
//        }
//
//TODO: test create operation
//    - Verifies that the service correctly adds a new entity.
//    - Checks that the list size increases or the entity is retrievable.
//    Example:
//        @Test
//        void testCreateAnimal() {
//            Animal parrot = new Animal(...);
//            animalService.create(parrot);
//            assertEquals(6, animalService.readAll().size());
//        }
//
//TODO: test update operation
//    - Verifies that the service correctly updates an existing entity.
//    - Checks that updated fields are reflected and unchanged fields remain.
//    Example:
//        @Test
//        void testUpdateAnimal() {
//            Animal animal = animalService.read(1L).orElseThrow();
//            animal.setName("Cat");
//            animalService.update(animal);
//            assertEquals("Cat", animalService.read(1L).get().getName());
//        }
//
//TODO: test read by ID operation
//    - Verifies that the service can retrieve an entity by its ID.
//    - Ensures the retrieved entity matches expected values.
//    Example:
//        @Test
//        void testReadAnimalById() {
//            Animal animal = animalService.read(2L).orElseThrow();
//            assertEquals("Lion", animal.getSpecies());
//        }
//
//TODO: test delete operation
//    - Verifies that the service correctly deletes an entity.
//    - Confirms that the entity is no longer retrievable and list size decreases.
//    Example:
//        @Test
//        void testDeleteAnimal() {
//            boolean deleted = animalService.delete(3L);
//            assertTrue(deleted);
//            assertTrue(animalService.read(3L).isEmpty());
//        }
//
//TODO: test read all operation
//    - Verifies that the service returns all stored entities.
//    - Confirms list size and optionally content.
//    Example:
//        @Test
//        void testReadAllAnimals() {
//            List<Animal> all = animalService.readAll();
//            assertEquals(6, all.size());
//        }
//
//TODO: test select by category or species
//    - Verifies that filtering methods correctly return matching entities.
//    - Confirms returned list size and content.
//    Example:
//        @Test
//        void testSelectFelines() {
//            List<Animal> felines = animalService.selectByCategory("Feline");
//            assertEquals(2, felines.size());
//        }
//
//TODO: use mock data factory
//    - Prepares consistent mock data for all tests.
//    - Ensures predictable and repeatable test results.
//    Example:
//        MockAnimalFactory.getMockAnimals().forEach(animalService::create);
}