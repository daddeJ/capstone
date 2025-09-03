package com.simulation.mocks;

import java.util.ArrayList;
import java.util.List;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Bird;
import com.simulation.animal.entities.category.Feline;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.entities.species.Cheetah;
import com.simulation.animal.entities.species.Elephant;
import com.simulation.animal.entities.species.Falcon;
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

    public static List<Animal> getMockBird() {
        List<Animal> bird = new ArrayList<>();

        Bird bird1 = new Bird() {{
            setId(1L);
            setAnimalId("A001");
            setName("Birdy Wonky");
            setCategory("Bird");
            setSpecies("Parrot");
            setHealthy(true);
            setBeaklength(1.7);
            setWingspan(2.1);
        }};

        Bird bird2 = new Bird() {{
            setId(2L);
            setAnimalId("A002");
            setName("Rumble Birdy");
            setCategory("Bird");
            setSpecies("Parrot");
            setHealthy(true);
            setBeaklength(1.8);
            setWingspan(2.3);
        }};

        Bird bird3 = new Bird() {{
            setId(3L);
            setAnimalId("A003");
            setName("Tusk Birdy");
            setCategory("Bird");
            setSpecies("Owl");
            setHealthy(false);
            setBeaklength(1.65);
            setWingspan(2.0);
        }};

        Bird bird4 = new Bird() {{
            setId(4L);
            setAnimalId("A004");
            setName("Birdy Blaster");
            setCategory("Bird");
            setSpecies("Owl");
            setHealthy(true);
            setBeaklength(1.75);
            setWingspan(2.2);
        }};

        Bird bird5 = new Bird() {{
            setId(5L);
            setAnimalId("A005");
            setName("Mud Birdy");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(false);
            setBeaklength(1.7);
            setWingspan(3.2);
        }};

        bird.add(bird1);
        bird.add(bird2);
        bird.add(bird3);
        bird.add(bird4);
        bird.add(bird5);

        return bird;
    }

    public static List<Animal> getMockFeline() {
        List<Animal> feline = new ArrayList<>();

        Feline feline1 = new Feline() {{
            setId(1L);
            setAnimalId("A001");
            setName("Birdy Wonky");
            setCategory("Bird");
            setSpecies("Parrot");
            setHealthy(true);
            setClawlength(1.7);
            setTaillength(2.1);
        }};

        Feline feline2 = new Feline() {{
            setId(2L);
            setAnimalId("A002");
            setName("Rumble Birdy");
            setCategory("Bird");
            setSpecies("Parrot");
            setHealthy(true);
            setClawlength(1.8);
            setTaillength(2.3);
        }};

        Feline feline3 = new Feline() {{
            setId(3L);
            setAnimalId("A003");
            setName("Tusk Birdy");
            setCategory("Bird");
            setSpecies("Owl");
            setHealthy(false);
            setClawlength(1.65);
            setTaillength(2.0);
        }};

        Feline feline4 = new Feline() {{
            setId(4L);
            setAnimalId("A004");
            setName("Birdy Blaster");
            setCategory("Bird");
            setSpecies("Owl");
            setHealthy(true);
            setClawlength(1.75);
            setTaillength(2.2);
        }};

        Feline feline5 = new Feline() {{
            setId(5L);
            setAnimalId("A005");
            setName("Mud Birdy");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(false);
            setClawlength(1.7);
            setTaillength(3.2);
        }};

        feline.add(feline1);
        feline.add(feline2);
        feline.add(feline3);
        feline.add(feline4);
        feline.add(feline5);

        return feline;
    }

    public static List<Animal> getMockCheetah() {
        List<Animal> cheetah = new ArrayList<>();

        Cheetah cheetah1 = new Cheetah() {{
            setId(5L);
            setAnimalId("A005");
            setName("Mud Birdy");
            setCategory("Feline");
            setSpecies("Cheetah");
            setHealthy(false);
            setClawlength(1.7);
            setTaillength(3.2);
            setSpotpattern("solid black round spots");
        }};

        Cheetah cheetah2 = new Cheetah() {{
            setId(6L);
            setAnimalId("A006");
            setName("Swift Runner");
            setCategory("Feline");
            setSpecies("Cheetah");
            setHealthy(true);
            setClawlength(2.1);
            setTaillength(3.5);
            setSpotpattern("dense small round spots");
        }};

        Cheetah cheetah3 = new Cheetah() {{
            setId(7L);
            setAnimalId("A007");
            setName("Shadow Blaze");
            setCategory("Feline");
            setSpecies("Cheetah");
            setHealthy(true);
            setClawlength(1.9);
            setTaillength(3.3);
            setSpotpattern("widely spaced medium spots");
        }};

        Cheetah cheetah4 = new Cheetah() {{
            setId(8L);
            setAnimalId("A008");
            setName("Luna Streak");
            setCategory("Feline");
            setSpecies("Cheetah");
            setHealthy(false);
            setClawlength(2.0);
            setTaillength(3.4);
            setSpotpattern("irregular clustered spots");
        }};

        Cheetah cheetah5 = new Cheetah() {{
            setId(9L);
            setAnimalId("A009");
            setName("Storm Dash");
            setCategory("Feline");
            setSpecies("Cheetah");
            setHealthy(true);
            setClawlength(2.2);
            setTaillength(3.6);
            setSpotpattern("fine dense black dots");
        }};

        cheetah.add(cheetah1);
        cheetah.add(cheetah2);
        cheetah.add(cheetah3);
        cheetah.add(cheetah4);
        cheetah.add(cheetah5);

        return cheetah;
    }

    public static List<Animal> getMockElephant() {
        List<Animal> elephant = new ArrayList<>();

        Elephant elephant1 = new Elephant() {{
            setId(1L);
            setAnimalId("E001");
            setName("Mud Mud");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(false);
            setTrunklength(3.2);
        }};

        Elephant elephant2 = new Elephant() {{
            setId(2L);
            setAnimalId("E002");
            setName("Dusty Giant");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(true);
            setTrunklength(2.9);
        }};

        Elephant elephant3 = new Elephant() {{
            setId(3L);
            setAnimalId("E003");
            setName("River Splash");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(true);
            setTrunklength(3.5);
        }};

        Elephant elephant4 = new Elephant() {{
            setId(4L);
            setAnimalId("E004");
            setName("Storm Tusk");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(false);
            setTrunklength(3.8);
        }};

        Elephant elephant5 = new Elephant() {{
            setId(5L);
            setAnimalId("E005");
            setName("Savanna King");
            setCategory("Pachyderm");
            setSpecies("Elephant");
            setHealthy(true);
            setTrunklength(4.0);
        }};

        elephant.add(elephant1);
        elephant.add(elephant2);
        elephant.add(elephant3);
        elephant.add(elephant4);
        elephant.add(elephant5);

        return elephant;
    }

    public static List<Animal> getMockFalcon() {
        List<Animal> falcon = new ArrayList<>();

        Falcon falcon1 = new Falcon() {{
            setId(1L);
            setAnimalId("F001");
            setName("Sky Hunter");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(false);
            setBeackstrength(4.3);
        }};

        Falcon falcon2 = new Falcon() {{
            setId(2L);
            setAnimalId("F002");
            setName("Wind Streak");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(true);
            setBeackstrength(5.1);
        }};

        Falcon falcon3 = new Falcon() {{
            setId(3L);
            setAnimalId("F003");
            setName("Storm Claw");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(true);
            setBeackstrength(4.8);
        }};

        Falcon falcon4 = new Falcon() {{
            setId(4L);
            setAnimalId("F004");
            setName("Shadow Wing");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(false);
            setBeackstrength(4.0);
        }};

        Falcon falcon5 = new Falcon() {{
            setId(5L);
            setAnimalId("F005");
            setName("Lightning Eye");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(true);
            setBeackstrength(5.4);
        }};

        falcon.add(falcon1);
        falcon.add(falcon2);
        falcon.add(falcon3);
        falcon.add(falcon4);
        falcon.add(falcon5);

        return falcon;
    }
}
