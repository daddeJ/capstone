package com.simulation.mocks;

import java.util.ArrayList;
import java.util.List;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Pachyderm;

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

    public static List<Animal> getMockPacyderm() {
        List<Animal> pachyderms = new ArrayList<>();

        Pachyderm rhino1 = new Pachyderm();
        rhino1.setId(1L);
        rhino1.setAnimalId("A001");
        rhino1.setName("Chunky Chucky");
        rhino1.setCategory("Pachyderm");
        rhino1.setSpecies("Rhinoceros");
        rhino1.setWeight(2300);
        rhino1.setHeight(1.7);

        Pachyderm rhino2 = new Pachyderm();
        rhino2.setId(2L);
        rhino2.setAnimalId("A002");
        rhino2.setName("Chewy Chucky");
        rhino2.setCategory("Pachyderm");
        rhino2.setSpecies("Rhinoceros");
        rhino2.setWeight(2500);
        rhino2.setHeight(1.8);

        Pachyderm hippo1 = new Pachyderm();
        hippo1.setId(3L);
        hippo1.setAnimalId("A003");
        hippo1.setName("Chubby Chucky");
        hippo1.setCategory("Pachyderm");
        hippo1.setSpecies("Hippopotamus");
        hippo1.setWeight(1500);
        hippo1.setHeight(1.5);

        Pachyderm hippo2 = new Pachyderm();
        hippo2.setId(4L);
        hippo2.setAnimalId("A004");
        hippo2.setName("Clumsy Chucky");
        hippo2.setCategory("Pachyderm");
        hippo2.setSpecies("Hippopotamus");
        hippo2.setWeight(1700);
        hippo2.setHeight(1.6);

        Pachyderm elephant = new Pachyderm();
        elephant.setId(5L);
        elephant.setAnimalId("A005");
        elephant.setName("Chaotic Chucky");
        elephant.setCategory("Pachyderm");
        elephant.setSpecies("Elephant");
        elephant.setWeight(5000);
        elephant.setHeight(3.2);

        pachyderms.add(rhino1);
        pachyderms.add(rhino2);
        pachyderms.add(hippo1);
        pachyderms.add(hippo2);
        pachyderms.add(elephant);

        return  pachyderms;
    }
}
