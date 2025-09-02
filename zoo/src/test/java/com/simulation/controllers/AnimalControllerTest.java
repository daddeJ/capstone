package com.simulation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.zoo.controllers.AnimalController;
import com.simulation.animal.entities.Animal;
import com.simulation.animal.services.interfaces.AnimalService;
import com.simulation.mocks.MockAnimalFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AnimalControllerTest {

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalController animalController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(animalController).build();
    }

    @Test
    void testCreateAnimal() throws Exception {
        Animal owl = new Animal() {{
            setId(7L);
            setAnimalId("A007");
            setName("Owl");
            setCategory("Bird");
            setSpecies("Owl");
            setHealthy(true);
        }};

        when(animalService.create(any(Animal.class))).thenReturn(owl);

        mockMvc.perform(post("/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(owl)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(7L))
                .andExpect(jsonPath("$.name").value("Owl"));
    }

    @Test
    void testUpdateAnimal() throws Exception{
        Animal tigerUpdate = MockAnimalFactory.getMockAnimals().get(0);
        tigerUpdate.setName("Chunky Tiger");

        when(animalService.update(any(Animal.class))).thenReturn(tigerUpdate);

        mockMvc.perform(put("/animals/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tigerUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Chunky Tiger"));
    }

    @Test
    void testDeleteAnimal_Success() throws Exception {
        when(animalService.delete(1L)).thenReturn(true);

        mockMvc.perform(delete("/animals/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteAnimal_NotFound() throws Exception {
        when(animalService.delete(99L)).thenReturn(false);

        mockMvc.perform(delete("/animals/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetAllAnimals_WithData() throws Exception {
        List<Animal> mockAnimals = MockAnimalFactory.getMockAnimals();
        when(animalService.readAll()).thenReturn(mockAnimals);

        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(6))) // Assuming MockAnimalFactory returns 5 animals
                .andExpect(jsonPath("$[0].name").value(mockAnimals.get(0).getName()))
                .andExpect(jsonPath("$[0].species").value(mockAnimals.get(0).getSpecies()))
                .andExpect(jsonPath("$[1].name").value(mockAnimals.get(1).getName()))
                .andExpect(jsonPath("$[4].category").value(mockAnimals.get(4).getCategory()));
    }

    @Test
    void testGetAllAnimals_EmptyList() throws Exception {
        when(animalService.readAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetAllAnimals_SingleAnimal() throws Exception {
        // Arrange - Mock single animal
        Animal singleAnimal = MockAnimalFactory.getMockAnimals().get(0);
        when(animalService.readAll()).thenReturn(Arrays.asList(singleAnimal));

        // Act & Assert
        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(singleAnimal.getId()))
                .andExpect(jsonPath("$[0].name").value(singleAnimal.getName()))
                .andExpect(jsonPath("$[0].healthy").value(singleAnimal.isHealthy()));
    }

    @Test
    void testGetAnimalById() throws Exception {
        Animal tiger = MockAnimalFactory.getMockAnimals().get(0);

        // Mock the service call
        when(animalService.read(1L)).thenReturn(Optional.of(tiger));

        mockMvc.perform(get("/animals/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(tiger.getId()))
                .andExpect(jsonPath("$.name").value(tiger.getName()))
                .andExpect(jsonPath("$.category").value(tiger.getCategory()))
                .andExpect(jsonPath("$.species").value(tiger.getSpecies()))
                .andExpect(jsonPath("$.healthy").value(tiger.isHealthy()));
    }

    @Test
    void testGetAnimalById_NotFound() throws Exception {
        when(animalService.read(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/animals/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetByCategory_WithResults() throws  Exception{
        List<Animal> felineAnimals = MockAnimalFactory.getMockAnimals().stream()
                .filter(a -> a.getCategory().equalsIgnoreCase("Feline"))
                .collect(Collectors.toList());

        when(animalService.selectByCategory("Feline")).thenReturn(felineAnimals);

        mockMvc.perform(get("/animals/category/Feline"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].category").value("Feline"))
                .andExpect(jsonPath("$[0].name").value("Tiger"))
                .andExpect(jsonPath("$[1].name").value("Lion"));
    }

    @Test
    void testGetByCategory_EmptyResults() throws Exception {
        when(animalService.selectByCategory("Reptile")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/animals/category/Reptile"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetByCategory_SingleResult() throws Exception {
        List<Animal> birdAnimals = MockAnimalFactory.getMockAnimals().stream()
                .filter(a -> a.getCategory().equalsIgnoreCase("bird"))
                .collect(Collectors.toList());

        when(animalService.selectByCategory("Bird")).thenReturn(birdAnimals);

        mockMvc.perform(get("/animals/category/Bird"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].category").value("Bird"))
                .andExpect(jsonPath("$[0].name").value("Parrot"));
    }

    @Test
    void testGetBySpecies_WithResults() throws Exception {
        List<Animal> elephantAnimals = MockAnimalFactory.getMockAnimals().stream()
                .filter(a -> a.getSpecies().equalsIgnoreCase("elephant"))
                .collect(Collectors.toList());

        when(animalService.selectBySpecies("Elephant")).thenReturn(elephantAnimals);

        mockMvc.perform(get("/animals/species/Elephant"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("[0].species").value("Elephant"))
                .andExpect(jsonPath("$[1].name").value("Elephant"));
    }

    @Test
    void testGetBySpecies_EmptyResults() throws Exception {
        when(animalService.selectBySpecies("Owl")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/animals/species/Owl"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetBySpecies_SingleResult() throws Exception {
        List<Animal> rhino = MockAnimalFactory.getMockAnimals().stream()
                .filter(a -> a.getSpecies().equalsIgnoreCase("rhino"))
                .collect(Collectors.toList());

        when(animalService.selectBySpecies("Rhino")).thenReturn(rhino);

        mockMvc.perform(get("/animals/species/Rhino"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].species").value("Rhino"))
                .andExpect(jsonPath("$[0].name").value("Rhino"));

    }

    @Test
    void testCreatePachyderm() throws Exception {
        Pachyderm elephant = new Pachyderm();
        elephant.setId(8L);
        elephant.setAnimalId("A008");
        elephant.setName("Chaotic Chucky");
        elephant.setCategory("Pachyderm");
        elephant.setSpecies("Elephant");
        elephant.setWeight(5000);
        elephant.setHeight(3.2);

        when(animalService.create(any(Animal.class))).thenReturn(elephant);

        mockMvc.perform(post("/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(elephant)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(8L))
                .andExpect(jsonPath("$.name").value("Chaotic Chucky"))
                .andExpect(jsonPath("$.weight").value(5000))
                .andExpect(jsonPath("$.height").value(3.2));
    }
}