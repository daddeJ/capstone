package com.simulation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simulation.animal.entities.species.Elephant;
import com.simulation.animal.entities.species.Rhino;
import com.simulation.animal.services.interfaces.species.ElephantService;
import com.simulation.animal.services.interfaces.species.RhinoService;
import com.simulation.mocks.MockAnimalFactory;
import com.simulation.zoo.controllers.species.ElephantController;
import com.simulation.zoo.controllers.species.RhinoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ElephantControllerTest {
//TODO: annotate test class with '@ExtendWith(MockitoExtension.class)'
//    - Enables Mockito annotations (@Mock, @InjectMocks) and integration with JUnit 5.
//    Example:
//        @ExtendWith(MockitoExtension.class)
//        public class AnimalControllerTest { ... }
//
    @Mock
    private ElephantService elephantService;

    @InjectMocks
    private ElephantController elephantController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
//TODO: mock dependencies with '@Mock'
//    - Creates mock instances of dependencies (services) for testing.
//    - Avoids calling actual implementations and allows controlled behavior.
//    Example:
//        @Mock
//        private AnimalService animalService;
//
//TODO: inject controller under test with '@InjectMocks'
//    - Creates an instance of the controller with mocks injected.
//    - Enables testing the controller independently.
//    Example:
//        @InjectMocks
//        private AnimalController animalController;
//
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(elephantController).build();
    }

    @Test
    void shoudlReturnLongestTrunkLength_WhenExists() throws Exception {
        Elephant elephant = (Elephant) MockAnimalFactory.getMockElephant().get(0);
        Optional<Elephant> optionalElephant = Optional.of(elephant);

        when(elephantService.getLongestTrunkLength()).thenReturn(optionalElephant);

        mockMvc.perform(get("/animals/species/elephant/maxtrunk")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(elephant.getName()))
                .andExpect(jsonPath("$.weight").value(elephant.getWeight()))
                .andExpect(jsonPath("$.height").value(elephant.getHeight()))
                .andExpect(jsonPath("$.species").value(elephant.getSpecies()))
                .andExpect(jsonPath("$.trunklength").value(elephant.getTrunklength()));
    }

    @Test
    void shouldReturnNotFound_WhenLongestTrunkLengthDoesNotExist() throws Exception{
        when(elephantService.getLongestTrunkLength()).thenReturn(Optional.empty());

        mockMvc.perform(get("/animals/species/elephant/maxtrunk")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
//TODO: set up MockMvc for controller testing
//    - Initializes MockMvc for standalone controller testing.
//    - Allows simulation of HTTP requests/responses without running the full server.
//    Example:
//        @BeforeEach
//        void setUp() {
//            mockMvc = MockMvcBuilders.standaloneSetup(animalController).build();
//        }
//
//TODO: test POST endpoint
//    - Simulates HTTP POST request to create a resource.
//    - Verifies response status and JSON content.
//    Example:
//        mockMvc.perform(post("/animals")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(animal)))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$.id").value(7L));
//
//TODO: test PUT endpoint
//    - Simulates HTTP PUT request to update a resource.
//    - Verifies response status and updated fields.
//    Example:
//        mockMvc.perform(put("/animals/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(updatedAnimal)))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$.name").value("Chunky Tiger"));
//
//TODO: test DELETE endpoint
//    - Simulates HTTP DELETE request.
//    - Verifies success (204 No Content) or failure (404 Not Found) response.
//    Example:
//        mockMvc.perform(delete("/animals/1"))
//               .andExpect(status().isNoContent());
//
//TODO: test GET endpoint for all resources
//    - Simulates HTTP GET request to fetch a list of resources.
//    - Verifies response status, content type, and size of returned list.
//    Example:
//        mockMvc.perform(get("/animals"))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$", hasSize(6)));
//
//TODO: test GET endpoint by ID
//    - Simulates HTTP GET request to fetch a single resource by ID.
//    - Verifies response status, content type, and returned fields.
//    Example:
//        mockMvc.perform(get("/animals/1"))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$.name").value("Tiger"));
//
//TODO: test GET endpoint by category/species
//    - Simulates HTTP GET request to fetch resources filtered by category or species.
//    - Verifies response status, content type, and filtered results.
//    Example:
//        mockMvc.perform(get("/animals/category/Feline"))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("$[0].category").value("Feline"));
//
//TODO: use ObjectMapper for JSON serialization/deserialization
//    - Converts Java objects to JSON string for request body.
//    - Converts response JSON to Java objects if needed.
//    Example:
//        objectMapper.writeValueAsString(animal);
}