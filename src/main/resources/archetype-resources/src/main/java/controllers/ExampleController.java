package ${package}.controllers;

import org.springframework.web.bind.annotation.RestController;

import ${package}.services.Service;

@RestController
public class Controller {

    private final Service service;

    public Controller(final Service service) {
        this.service = service;
    }

}
