package com.simulation.zoo.controllers;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.services.implementations.AnimalServiceImpl;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.generics.implementations.CrudServiceImpl;
import com.simulation.generics.interfaces.CrudService;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("animals")
@Tag(name = "Animals", description = "Animals management API")
public class AnimalController {
    private CrudService<Animal, Long> crudService;
    private AnimalService animalService;

    public  AnimalController() {
        crudService = new CrudServiceImpl<>();
        animalService = new AnimalServiceImpl(crudService);
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal created = animalService.create(animal);
        return  ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        Optional<Animal> animal = animalService.read(id);
        return  animal.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Get all animals", description = "Returns a list of all animals in the zoo")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public  ResponseEntity<List<Animal>> getAllAnimals() {
        return ResponseEntity.ok(animalService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id);
        Animal updated = animalService.update(animal);
        return  ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        boolean deleted = animalService.delete(id);
        if (deleted) {
            return  ResponseEntity.noContent().build();
        }

        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Animal>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(animalService.selectByCategory(category));
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<List<Animal>> getBySpecies(@PathVariable String species) {
        return ResponseEntity.ok(animalService.selectBySpecies(species));
    }
}
