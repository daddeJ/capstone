package com.simulation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.services.interfaces.category.PachydermService;
import com.simulation.zoo.controllers.category.PachydermController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PacydermControllerTest {
    @Mock
    private PachydermService pachydermService;

    @InjectMocks
    private PachydermController pachydermController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(pachydermController).build();
    }

    @Test
    void shouldReturnHeaviestPachyderm_WhenExists() throws Exception {
        // Given
        Pachyderm pachyderm = createTestPachyderm();
        Optional<Pachyderm> optionalPachyderm = Optional.of(pachyderm);

        when(pachydermService.getHeaviestPachyderm()).thenReturn(optionalPachyderm);

        // When & Then
        mockMvc.perform(get("/animals/category/pachyderm/heaviest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(pachyderm.getName()))
                .andExpect(jsonPath("$.weight").value(pachyderm.getWeight()))
                .andExpect(jsonPath("$.height").value(pachyderm.getHeight()))
                .andExpect(jsonPath("$.species").value(pachyderm.getSpecies()));
    }

    @Test
    void shouldReturnNotFound_WhenHeaviestPachydermDoesNotExist() throws Exception {
        // Given
        when(pachydermService.getHeaviestPachyderm()).thenReturn(Optional.empty());

        // When & Then
        mockMvc.perform(get("/animals/category/pachyderm/heaviest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnTallestPachyderm_WhenExists() throws Exception {
        // Given
        Pachyderm pachyderm = createTestPachyderm();
        Optional<Pachyderm> optionalPachyderm = Optional.of(pachyderm);

        when(pachydermService.getTallestPachyderm()).thenReturn(optionalPachyderm);

        // When & Then
        mockMvc.perform(get("/animals/category/pachyderm/tallest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(pachyderm.getName()))
                .andExpect(jsonPath("$.height").value(pachyderm.getHeight()));
    }

    @Test
    void shouldReturnNotFound_WhenTallestPachydermDoesNotExist() throws Exception {
        // Given
        when(pachydermService.getTallestPachyderm()).thenReturn(Optional.empty());

        // When & Then
        mockMvc.perform(get("/animals/category/pachyderm/tallest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private Pachyderm createTestPachyderm() {
        Pachyderm pachyderm = new Pachyderm();
        pachyderm.setId(5L);
        pachyderm.setAnimalId("A005");
        pachyderm.setName("Chaotic Chucky");
        pachyderm.setCategory("Pachyderm");
        pachyderm.setSpecies("Elephant");
        pachyderm.setWeight(5000);
        pachyderm.setHeight(3.2);
        return pachyderm;
    }
}