package com.simulation.zoo.controllers.category;

import com.simulation.animal.entities.category.Pachyderm;
import com.simulation.animal.services.interfaces.category.PachydermService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/animals/category/pachyderm")
@Tag(name = "Category - Pachyderm", description = "Pachyderm operation")
public class PachydermController {
    private final PachydermService pachydermService;

    public PachydermController(PachydermService pachydermService) {
        this.pachydermService = pachydermService;
    }

    @GetMapping("/heaviest")
    public ResponseEntity<Pachyderm> getHeaviestPachyderm() {
        Optional<Pachyderm> pachyderm = pachydermService.getHeaviestPachyderm();
        return  pachyderm.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tallest")
    public ResponseEntity<Pachyderm> getTallestPachyderm() {
        Optional<Pachyderm> pachyderm = pachydermService.getTallestPachyderm();
        return  pachyderm.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
