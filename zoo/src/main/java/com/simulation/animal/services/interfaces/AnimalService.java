package com.simulation.animal.services.interfaces;

import java.util.List;

import com.simulation.animal.entities.Animal;
import com.simulation.generics.interfaces.CrudService;

public interface AnimalService extends CrudService<Animal, Long>{
    // TODO: define operation
    List<Animal> selectByCategory(String category);
    List<Animal> selectBySpecies(String species);
}
