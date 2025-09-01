package com.simulation.mocks;

import java.util.ArrayList;
import java.util.List;

import com.simulation.animal.entities.Animal;

public class MockAnimalFactory {
    public static List<Animal> getMockAnimals() {
        List<Animal> animals = new ArrayList<>();

        Animal tiger = new Animal() {{
            setId(1L);
            setAnimalId("A001");
            setName("Tiger");
            setCategory("Feline");
            setSpecies("Tiger");
            setHealthy(true);
        }};

        Animal lion = new Animal() {{
            setId(2L);
            setAnimalId("A002");
            setName("Lion");
            setCategory("Feline");
            setSpecies("Lion");
            setHealthy(true);
        }};

        Animal elephant1 = new Animal() {{
            setId(3L);
            setAnimalId("A003");
            setName("Jonny");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(true);
        }};

        Animal elephant2 = new Animal() {{
            setId(4L);
            setAnimalId("A004");
            setName("Elephant");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(true);
        }};

        Animal rhino = new Animal() {{
            setId(5L);
            setAnimalId("A005");
            setName("Rhino");
            setCategory("Pachyderm");
            setSpecies("Rhino");
            setHealthy(true);
        }};

        Animal parrot = new Animal() {{
            setId(6L);
            setAnimalId("A006");
            setName("Parrot");
            setCategory("Bird");
            setSpecies("Parrot");
            setHealthy(true);
        }};

        animals.add(tiger);
        animals.add(lion);
        animals.add(elephant1);
        animals.add(elephant2);
        animals.add(rhino);
        animals.add(parrot);

        return animals;
    }
}
