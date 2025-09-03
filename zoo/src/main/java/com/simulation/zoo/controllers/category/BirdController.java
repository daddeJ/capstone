package com.simulation.zoo.controllers.category;

import com.simulation.animal.entities.category.Bird;
import com.simulation.animal.services.interfaces.category.BirdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
//TODO: define annotation as '@RestController'
//    - Marks a class as a REST API controller.
//    - Methods return data (JSON/XML) directly in the HTTP response instead of rendering a view.
//    Example:
//        @RestController
//        public class ExampleController { ... }

//TODO: define annotation as '@RequestMapping("/parent/child/type")'
//    - Maps HTTP requests with the specified path to the annotated class or method.
//    Example:
//        @RequestMapping("/api/pachyderms")
//        public class PachydermController { ... }

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

@RestController
@RequestMapping("animals/category/bird")
@Tag(name = "Category - Bird", description = "Bird operation")
public class BirdController {
//TODO: inject services in the constructor
//    - Uses constructor injection to provide the controller with required service dependencies.
//    - Promotes loose coupling and easier testing.
//    Example:
//        public PachydermController(PachydermService pachydermService) {
//            this.pachydermService = pachydermService;
//        }
    private final BirdService birdService;
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }
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
    @GetMapping("/wingspan")
    public ResponseEntity<Bird> getLongestWingspan() {
        Optional<Bird> bird = birdService.getLongestWingSpan();
        return bird.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/beak")
    public ResponseEntity<Bird> getLongestBeak() {
        Optional<Bird> bird = birdService.getLongestBeak();
        return bird.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
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