package com.simulation.zoo.config;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.implementations.category.PachydermServiceImpl;
import com.simulation.animal.services.implementations.species.RhinoServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.animal.services.interfaces.category.PachydermService;
import com.simulation.animal.services.interfaces.species.RhinoService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
TODO: annotate configuration class with '@Configuration'
    - Marks the class as a Spring configuration class.
    - Enables Spring to detect @Bean definitions and manage them in the application context.
    Example:
        @Configuration
        public class ServiceConfiguration { ... }

TODO: define generic CrudService bean
    - Provides a reusable CRUD service for entities.
    - Can be injected into other services that require basic CRUD operations.
    Example:
        @Bean
        public CrudService<Animal, Long> crudService() {
            return new CrudServiceImpl<>();
        }

TODO: define AnimalService bean
    - Configures the AnimalService implementation.
    - Injects the required CrudService dependency via constructor.
    Example:
        @Bean
        public AnimalService animalService(CrudService<Animal, Long> crudService) {
            return new AnimalServiceImpl(crudService);
        }

TODO: define PachydermService bean
    - Configures the PachydermService implementation for pachyderm-specific operations.
    - Reuses the generic CrudService dependency.
    Example:
        @Bean
        public PachydermService pachydermService(CrudService<Animal, Long> crudService) {
            return new PachydermServiceImpl(crudService);
        }

TODO: define RhinoService bean
    - Configures the RhinoService implementation for rhino-specific operations.
    - Reuses the generic CrudService dependency.
    Example:
        @Bean
        public RhinoService rhinoService(CrudService<Animal, Long> crudService) {
            return new RhinoServiceImpl(crudService);
        }

TODO: general service configuration structure
    - Class-level annotation: @Configuration
    - Defines @Bean methods for all service layer dependencies.
    - Allows Spring to manage and inject services across controllers and other components.
*/

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
    @Bean
    public PachydermService pachydermService(CrudService<Animal, Long> crudService) {
        return new PachydermServiceImpl(crudService);
    }
    @Bean
    public RhinoService rhinoService(CrudService<Animal, Long> crudService) {
        return new RhinoServiceImpl(crudService);
    }
}
