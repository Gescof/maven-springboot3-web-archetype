package ${package}.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;
import ${package}.services.ExampleService;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/examples")
public class ExampleController {

    private final ExampleService service;

    @PostMapping
    public ResponseEntity<Void> createExample(@RequestBody @Valid final NewExampleDTO newExample) {
        log.info("POST /examples");
        service.createExample(newExample);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExampleDTO> getExample(@PathVariable @NotNull final Long id) {
        log.info("GET /examples/{}", id);
        return ResponseEntity.ok(service.getExample(id));
    }

}
