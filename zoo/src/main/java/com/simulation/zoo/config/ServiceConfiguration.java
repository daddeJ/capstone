package com.simulation.zoo.config;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CrudService<Animal, Long> crudService() {
        return new CrudServiceImpl<>();
    }

    @Bean
    public AnimalService animalService(CrudService<Animal, Long> crudService) {
        return new AnimalServiceImpl(crudService);
    }
}
