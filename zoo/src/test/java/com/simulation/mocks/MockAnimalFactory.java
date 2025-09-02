package com.simulation.mocks;

import java.util.ArrayList;
import java.util.List;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.entities.species.Rhino;

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

        Pachyderm rhino1 = new Pachyderm() {{
            setId(1L);
            setAnimalId("A001");
            setName("Chunky Chucky");
            setCategory("Pachyderm");
            setSpecies("Rhinoceros");
            setWeight(2300);
            setHeight(1.7);
        }};


        Pachyderm rhino2 = new Pachyderm() {{
            setId(2L);
            setAnimalId("A002");
            setName("Chewy Chucky");
            setCategory("Pachyderm");
            setSpecies("Rhinoceros");
            setWeight(2500);
            setHeight(1.8);
        }};


        Pachyderm hippo1 = new Pachyderm() {{
            setId(3L);
            setAnimalId("A003");
            setName("Chubby Chucky");
            setCategory("Pachyderm");
            setSpecies("Hippopotamus");
            setWeight(1500);
            setHeight(1.5);
        }};


        Pachyderm hippo2 = new Pachyderm() {{
            setId(4L);
            setAnimalId("A004");
            setName("Clumsy Chucky");
            setCategory("Pachyderm");
            setSpecies("Hippopotamus");
            setWeight(1700);
            setHeight(1.6);
        }};


        Pachyderm elephant = new Pachyderm() {{
            setId(5L);
            setAnimalId("A005");
            setName("Chaotic Chucky");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setWeight(5000);
            setHeight(3.2);
        }};

        pachyderms.add(rhino1);
        pachyderms.add(rhino2);
        pachyderms.add(hippo1);
        pachyderms.add(hippo2);
        pachyderms.add(elephant);

        return  pachyderms;
    }

    public static List<Animal> getMockRhino() {
        List<Animal> rhino = new ArrayList<>();

        Rhino rhino1 = new Rhino() {{
            setId(1L);
            setAnimalId("A005");
            setName("Chuck Wonky");
            setCategory("Pachyderm");
            setSpecies("Rhino");
            setHealthy(true);
            setWeight(2300);
            setHeight(1.7);
            setHornlength(2.1);
        }};

        Rhino rhino2 = new Rhino() {{
            setId(2L);
            setAnimalId("A006");
            setName("Rumble Horn");
            setCategory("Pachyderm");
            setSpecies("Rhino");
            setHealthy(true);
            setWeight(2400);
            setHeight(1.8);
            setHornlength(2.3);
        }};

        Rhino rhino3 = new Rhino() {{
            setId(3L);
            setAnimalId("A007");
            setName("Tusk Titan");
            setCategory("Pachyderm");
            setSpecies("Rhino");
            setHealthy(false);
            setWeight(2200);
            setHeight(1.65);
            setHornlength(2.0);
        }};

        Rhino rhino4 = new Rhino() {{
            setId(4L);
            setAnimalId("A008");
            setName("Horn Blaster");
            setCategory("Pachyderm");
            setSpecies("Rhino");
            setHealthy(true);
            setWeight(2350);
            setHeight(1.75);
            setHornlength(2.2);
        }};

        Rhino rhino5 = new Rhino() {{
            setId(5L);
            setAnimalId("A009");
            setName("Mud Stomper");
            setCategory("Pachyderm");
            setSpecies("Rhino");
            setHealthy(false);
            setWeight(2250);
            setHeight(1.7);
            setHornlength(3.2);
        }};

        rhino.add(rhino1);
        rhino.add(rhino2);
        rhino.add(rhino3);
        rhino.add(rhino4);
        rhino.add(rhino5);

        return rhino;
    }
}
