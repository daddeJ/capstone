package com.simulation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simulation.animal.entities.category.Bird;
import com.simulation.animal.services.interfaces.category.BirdService;
import com.simulation.zoo.controllers.category.BirdController;
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
public class BirdControllerTest {
//TODO: annotate test class with '@ExtendWith(MockitoExtension.class)'
//    - Enables Mockito annotations (@Mock, @InjectMocks) and integration with JUnit 5.
//    Example:
//        @ExtendWith(MockitoExtension.class)
//        public class AnimalControllerTest { ... }
//
//TODO: mock dependencies with '@Mock'
//    - Creates mock instances of dependencies (services) for testing.
//    - Avoids calling actual implementations and allows controlled behavior.
//    Example:
//        @Mock
//        private AnimalService animalService;
//
    @Mock
    private BirdService birdService;
//TODO: inject controller under test with '@InjectMocks'
//    - Creates an instance of the controller with mocks injected.
//    - Enables testing the controller independently.
//    Example:
//        @InjectMocks
//        private AnimalController animalController;
//
    @InjectMocks
    private BirdController birdController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
//TODO: set up MockMvc for controller testing
//    - Initializes MockMvc for standalone controller testing.
//    - Allows simulation of HTTP requests/responses without running the full server.
//    Example:
//        @BeforeEach
//        void setUp() {
//            mockMvc = MockMvcBuilders.standaloneSetup(animalController).build();
//        }
//
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(birdController).build();
    }

    @Test
    void shouldReturnLongestWingspanLength_WhenExists() throws Exception {
        Bird bird  = createMockBird();
        Optional<Bird> optionalBird = Optional.of(bird);

        when(birdService.getLongestWingSpan()).thenReturn(optionalBird);

        mockMvc.perform(get("/animals/category/bird/wingspan")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(bird.getName()))
                .andExpect(jsonPath("$.species").value(bird.getSpecies()))
                .andExpect(jsonPath("$.wingspan").value(bird.getWingspan()));
    }

    @Test
    void shouldReturnLongestWingspanLength_WhenNotExists() throws Exception {
        when(birdService.getLongestWingSpan()).thenReturn(Optional.empty());

        mockMvc.perform(get("/animals/category/bird/wingspan")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnLongestBeakLength_WhenExists() throws Exception {
        Bird bird  = createMockBird();
        Optional<Bird> optionalBird = Optional.of(bird);

        when(birdService.getLongestBeak()).thenReturn(optionalBird);

        mockMvc.perform(get("/animals/category/bird/beak")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(bird.getName()))
                .andExpect(jsonPath("$.species").value(bird.getSpecies()))
                .andExpect(jsonPath("$.beaklength").value(bird.getBeaklength()));
    }

    @Test
    void shouldReturnLongestBeakLength_WhenNotExists() throws Exception {
        when(birdService.getLongestBeak()).thenReturn(Optional.empty());

        mockMvc.perform(get("/animals/category/bird/beak")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private Bird createMockBird() {
        Bird bird = new Bird() {{
            setId(5L);
            setAnimalId("A005");
            setName("Mud Birdy");
            setCategory("Bird");
            setSpecies("Falcon");
            setHealthy(false);
            setBeaklength(1.7);
            setWingspan(3.2);
        }};
        return bird;
    }
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