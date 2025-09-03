package com.simulation.zoo.controllers.category;

import com.simulation.animal.entities.Animal;
import com.simulation.animal.entities.category.Feline;
import com.simulation.animal.services.interfaces.category.FelineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("animals/category/feline")
@Tag(name = "Category - Feline", description = "Feline Operation")
public class FelineController {
//TODO: define annotation as '@RestController'
//    - Marks a class as a REST API controller.
//    - Methods return data (JSON/XML) directly in the HTTP response instead of rendering a view.
//    Example:
//        @RestController
//        public class ExampleController { ... }
    private final FelineService felineService;
//TODO: define annotation as '@RequestMapping("/parent/child/type")'
//    - Maps HTTP requests with the specified path to the annotated class or method.
//    Example:
//        @RequestMapping("/api/pachyderms")
//        public class PachydermController { ... }
    public FelineController(FelineService felineService) {
        this.felineService = felineService;
    }

    @GetMapping("/claw")
    public ResponseEntity<Feline> getLongestClawLength() {
        Optional<Feline> feline = felineService.getLongestClawLength();
        return feline.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tail")
    public ResponseEntity<Feline> getLongestTailLength() {
        Optional<Feline> feline = felineService.getLongestTailLength();
        return feline.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//TODO: define annotation as '@Tag(name = "Category - Pachyderm", description = "Pachyderm operation")'
//    - Adds metadata for API documentation (OpenAPI/Swagger).
//    - Categorizes endpoints under a specific name with a description.
//    Example:
//        @Tag(name = "Category - Pachyderm", description = "Pachyderm operation")

//TODO: declare service for the controller
//    - Marks a class as a service component that contains business logic.
//    - Service can be injected into controllers to handle operations.
//    Example:
//        @Service
//        public class PachydermService { ... }

//TODO: inject services in the constructor
//    - Uses constructor injection to provide the controller with required service dependencies.
//    - Promotes loose coupling and easier testing.
//    Example:
//        public PachydermController(PachydermService pachydermService) {
//            this.pachydermService = pachydermService;
//        }

//TODO: define endpoint methods
//    - Handles HTTP requests for a specific path and method (GET, POST, PUT, DELETE, etc.).
//    - Invokes the corresponding service/interface operation.
//    - Returns an appropriate ResponseEntity based on the result (e.g., 200 OK with data, 404 Not Found, 400 Bad Request).
//    Example:
//        @GetMapping("/heaviest")
//        public ResponseEntity<Pachyderm> getHeaviestPachyderm() {
//            Optional<Pachyderm> pachyderm = pachydermService.getHeaviestPachyderm();
//            return pachyderm.map(ResponseEntity::ok)
//                            .orElse(ResponseEntity.notFound().build());
//        }

//TODO: general controller structure
//    - Class-level: @RestController, @RequestMapping, @Tag
//    - Dependencies: Service components injected via constructor
//    - Methods: Annotated with @GetMapping, @PostMapping, etc., delegating operations to services and returning ResponseEntity
//    Example:
//        @RestController
//        @RequestMapping("/api/pachyderms")
//        @Tag(name = "Category - Pachyderm", description = "Pachyderm operation")
//        public class PachydermController {
//            private final PachydermService pachydermService;
//            public PachydermController(PachydermService pachydermService) {
//                this.pachydermService = pachydermService;
//            }
//            @GetMapping("/heaviest")
//            public ResponseEntity<Pachyderm> getHeaviestPachyderm() {
//                Optional<Pachyderm> pachyderm = pachydermService.getHeaviestPachyderm();
//                return pachyderm.map(ResponseEntity::ok)
//                                .orElse(ResponseEntity.notFound().build());
//            }
//        }
}