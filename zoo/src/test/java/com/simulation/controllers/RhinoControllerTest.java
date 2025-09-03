package com.simulation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.entities.species.Rhino;
import com.simulation.animal.services.interfaces.species.RhinoService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class RhinoControllerTest {
    @Mock
    private RhinoService rhinoService;

    @InjectMocks
    private RhinoController rhinoController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(rhinoController).build();
    }

    @Test
    void shoudlReturnLongestHornLength_WhenExists() throws Exception {
        Rhino rhino = createTestRhino();
        Optional<Rhino> optionalRhino = Optional.of(rhino);

        when(rhinoService.getLongestHornLength()).thenReturn(optionalRhino);

        mockMvc.perform(get("/animals/species/rhino/longest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(rhino.getName()))
                .andExpect(jsonPath("$.weight").value(rhino.getWeight()))
                .andExpect(jsonPath("$.height").value(rhino.getHeight()))
                .andExpect(jsonPath("$.species").value(rhino.getSpecies()))
                .andExpect(jsonPath("$.hornlength").value(rhino.getHornlength()));
    }

    @Test
    void shouldReturnNotFound_WhenLongestHornLengthDoesNotExist() throws Exception{
        when(rhinoService.getLongestHornLength()).thenReturn(Optional.empty());

        mockMvc.perform(get("/animals/species/rhino/longest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private Rhino createTestRhino() {
        Rhino rhino = new Rhino() {{
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
        return rhino;
    }
}
