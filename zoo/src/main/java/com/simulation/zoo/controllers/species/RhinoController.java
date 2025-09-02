package com.simulation.zoo.controllers.species;

import com.simulation.animal.entities.species.Rhino;
import com.simulation.animal.services.interfaces.species.RhinoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/animals/species/rhino")
@Tag(name = "Species - Rhino", description = "Rhino operation")
public class RhinoController {
    private final RhinoService rhinoService;

    public RhinoController(RhinoService rhinoService) {
        this.rhinoService = rhinoService;
    }

    @GetMapping("/longest")
    public ResponseEntity<Rhino> getLongestHornLength() {
        Optional<Rhino> rhino = rhinoService.getLongestHornLength();

        return rhino.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}